module.exports = {
    apps: [
        {
            name: "doctor-service",
            script: "java",
            args: "-jar target/doctor-service-0.0.1-SNAPSHOT.jar",
            interpreter: "none",
            autorestart: true,
            max_restarts: 10,
            restart_delay: 3000
        }
    ]
};