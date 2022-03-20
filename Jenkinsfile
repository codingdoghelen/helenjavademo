pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'chmod +x gradlew'
                sh './gradlew build --scan'
                echo 'End Building..'
                }
        }
        stage('Test'){
            steps{
                echo 'Testing..'
                 withCredentials([usernamePassword(credentialsId: 'graceGithub', usernameVariable: 'GIT_USERNAME', passwordVariable: 'GIT_PASSWORD')])
                {
                    
                    //sh("git stash")                   
                    //sh("git branch -d tmp") 
                    sh('git checkout -B tmp')
                    
                    sh('chmod +x gradlew')
                   
		            echo 'Testing..'
                    //sh('mv src/main/swagger/swagger_ext.json.bak src/main/swagger/swagger_ext.json')
                    sh('./gradlew test')
                    sh('pwd')
                    sh('ls -lrt src/main')
                    sh('ls -lrt src/main/swagger')
                    //sh('gradle test')
                    //sh('pwd')
                    //sh('ls -lrt src/main')
                    //sh('ls -lrt src/main/swagger')
                    sh('git add -A')
                    sh('git commit -am \'update json by Jenkins\'')
                    sh("git branch -v -a")
                    sh("git checkout release")
                    sh("git pull")
                    
                    sh("git merge -X theirs tmp")
                    sh("git checkout --theirs *.json")
                    echo 'merge release and tmp'
                    //sh('ls -lrt src/main')
                    //sh('ls -lrt src/main/swagger')
                    sh ('git remote set-url origin https://$GIT_USERNAME:$GIT_PASSWORD@github.com/codingdoghelen/java-springboot-api-demo.git')
                    
                     //sh('git add -A')
                    //sh('git commit -am \'update json by Jenkins\'')
                    sh ("git push -u origin release")                    
                    sh("git branch -d tmp")
           
                }                
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
