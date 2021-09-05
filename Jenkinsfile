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
                            sh "mvn compile"
                        }
                    }
                }
            }

            stage('Test') {
                        steps {
                            script {
                                dir("${env.WORKSPACE}/project") {
                                    sh "mvn test"
                                }
                            }
                        }
                    }

            stage("Build Jar") {
                        steps {
                            script {
                                dir("${env.WORKSPACE}/project") {
                                    sh "mvn package"
                                }
                            }
                        }
                    }

            stage("deploy") {
                steps {
                    script {
                        dir("${env.WORKSPACE}/jars") {
                            sh "java -jar ./target/Rachael-0.0.1-SNAPSHOT.jar nohup &"
                            sh "rm -rf ${env.WORKSPACE}/project"
                        }
                    }
                }
            }
    }
}