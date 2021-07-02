pipeline {
    agent any
    stages {
        stage('Build Source') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'docker build -t vipulfadtedev/sys-stat-service:latest .'
            }
        }
        stage('Tag Docker Image') {
            steps {
                sh 'docker ps'
            }
        }
        stage('Stop running container') {
            steps {
                sh 'docker stop `docker ps -aqf "name=sys-stat-service"`'
            }
        }
        stage('Start new container') {
            steps {
                sh 'docker run --name sys-stat-service --rm --restart unless-stopped -dp 5000:8080 vipulfadtedev/sys-stat-service:latest'
            }
        }
    }
}