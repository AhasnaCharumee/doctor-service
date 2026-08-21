package com.hospital.doctor_service.service;

import com.hospital.doctor_service.model.Doctor;
import com.hospital.doctor_service.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(String id) {
        return doctorRepository.findById(id).orElse(null);
    }

    public Doctor updateDoctor(String id, Doctor updatedDoctor) {
        Doctor existing = doctorRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(updatedDoctor.getName());
            existing.setSpecialization(updatedDoctor.getSpecialization());
            existing.setContactNumber(updatedDoctor.getContactNumber());
            existing.setAvailableDays(updatedDoctor.getAvailableDays());
            return doctorRepository.save(existing);
        }
        return null;
    }

    public void deleteDoctor(String id) {
        doctorRepository.deleteById(id);
    }
}