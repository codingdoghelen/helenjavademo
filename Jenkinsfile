pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh '
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
                withCredentials([usernamePassword(credentialsId: 'graceGithub', usernameVariable: 'GIT_USERNAME', passwordVariable: 'GIT_PASSWORD')])
                {
                    sh("git stash")
                    sh("git checkout release") 
                    sh("git pull")
                    sh("git checkout -b tmp")
                    sh("git checkout release") 
                    sh("git merge tmp")     
                    sh("git branch -d tmp")

                    sh ('git remote set-url origin https://$GIT_USERNAME:$GIT_PASSWORD@github.com/codingdoghelen/java-springboot-api-demo.git')
                    sh ("git push -u origin release")
                    echo 'test push'
                    //sh("git push")


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
