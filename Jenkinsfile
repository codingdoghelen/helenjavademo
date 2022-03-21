pipeline {
    agent any

    stages {
    stage('clone repos') {
        steps {
        
            //cleanWs()
            
            withCredentials([usernamePassword(credentialsId: 'graceGithub', usernameVariable: 'GIT_USERNAME', passwordVariable: 'GIT_PASSWORD')])
            {
                dir('generateapicommon_helen') {
                    checkout([
                        $class: 'GitSCM',
                        branches: [[name: "release" ]],
                        extensions: [[$class: 'PruneStaleBranch']],
                        userRemoteConfigs: [[
                            url: '$GIT_USERNAME:$GIT_PASSWORD@github.com/GraceCWY/GenerateAPICommon.git',
                        ]]
                    ])
                }

                dir('java-springboot-api-demo') {
                    checkout([
                        $class: 'GitSCM',
                        branches: [[name: "dev" ]],
                        extensions: [[$class: 'PruneStaleBranch']],
                        userRemoteConfigs: [[
                            url: '$GIT_USERNAME:$GIT_PASSWORD@github.com/codingdoghelen/java-springboot-api-demo.git',
                        ]]
                    ])
                }
            }
        }
    }
    
    stage('Move file') {
        steps {
            dir('generateapicommon_helen') {
                dir('scripts/Jenkins') {
                    sh('cp -R ../java-springboot-api-demo/src/main/swagger /swagger')
                }
            }
        }
    }
    
    stage('commit and push') {
        steps {
           dir('generateapicommon_helen') {
                 sh 'git add it -A'
                 sh 'git commit -m "copy json from swagger"'
                 //sh ('git remote set-url origin https://$BITBUCKET_USERNAME:$BITBUCKET_PASSWORD@bitbucket.org/helenwong11/generateapicommon_helen.git')
                 sh ("git push -u origin dev")
           }
        }
    }
}
}
