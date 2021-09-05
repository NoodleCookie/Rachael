pipeline {
  agent any
  tools{
    maven "M3"
  }
    stages {
        stage('pull code') {
            steps{
                sh "mkdir ${env.WORKSPACE}/project"
                dir("${env.WORKSPACE}/project") {
                    git 'https://gitee.com/sakai-izumi/Rachael.git'
                    }
               }
            }

        stage('compile'){
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

            stage("deploy") {
                steps {
                    script {
                        dir("${env.WORKSPACE}/project") {
                            sh "java -jar ./target/Rachael-0.0.1-SNAPSHOT.jar nohup &"
                        }
                        println('deploy!')
                    }
                }
            }
    }
}