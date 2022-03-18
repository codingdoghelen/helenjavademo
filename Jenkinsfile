pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'chmod +x gradlew'
                sh './gradlew build'
                echo 'End Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh './gradlew test'
                echo 'End Testing..'
            }
        }
//        stage('Build Docker image') {
//            steps {
//                sh './gradlew docker'
//            }
//        }
//        stage('Push Docker image') {
//            environment {
//                DOCKER_HUB_LOGIN = credentials('docker-hub')
//            }
//            steps {
//                sh 'docker login --username=$DOCKER_HUB_LOGIN_USR --password=$DOCKER_HUB_LOGIN_PSW'
//                sh './gradlew dockerPush'
//            }
//        }
    }
}
