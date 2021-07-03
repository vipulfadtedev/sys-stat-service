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
                sh 'docker build -t vipulfadtedev/sys-stat-service:$BUILD_NUMBER .'
            }
        }
        stage('Push Docker Image') {
            steps {
                sh 'docker push vipulfadtedev/sys-stat-service:$BUILD_NUMBER'
                sh 'docker tag vipulfadtedev/sys-stat-service:$BUILD_NUMBER vipulfadtedev/sys-stat-service:latest'
                sh 'docker push vipulfadtedev/sys-stat-service:latest'
            }
        }
        stage('Deploy') {
            steps {
                sh 'sed -i "s|#image#|vipulfadtedev/sys-stat-service:""$BUILD_NUMBER""|" deploy/deploy.yaml'
                sh 'kubectl apply -f deploy/.'
            }
        }
    }
}