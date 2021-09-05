pipeline {
  agent any
//   tools{
//     maven "M3"
//   }
    stages {
        stage('Pull Code') {
            steps{
                sh "rm -rf ${env.WORKSPACE}/project"
                sh "mkdir ${env.WORKSPACE}/project"
                dir("${env.WORKSPACE}/project") {
                    git 'https://gitee.com/sakai-izumi/Rachael.git'
                    }
               }
            }

        stage('Compile'){
                steps{
                    script{
                        dir("${env.WORKSPACE}/project"){
                            sh "mvn clean compile"
                        }
                    }
                }
            }

            stage("Build Jar") {
                        steps {
                            script {
                                dir("${env.WORKSPACE}/project") {
                                    sh "mvn clean package"
                                }
                            }
                        }
                    }

//             stage("Deploy") {
//                 steps {
//                     script {
//                         dir("${env.WORKSPACE}/project") {
//                             sh "java -jar ./target/Rachael-0.0.1-SNAPSHOT.jar nohup &"
//                         }
//                     }
//                 }
//             }

            stage("Build Image and Publish") {
                 steps {
                     script {
                         dir("${env.WORKSPACE}/project") {
                             sh "docker build -t rachael:v1 ."
                             sh "docker images"
                         }
                     }
                 }
             }
    }
}