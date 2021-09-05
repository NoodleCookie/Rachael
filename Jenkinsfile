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
                    git 'https://github.com/NoodleCookie/Rachael.git'
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
                                    sh "mv ./target/Rachael-0.0.1-SNAPSHOT.jar ${env.WORKSPACE}/jars"
                                    sh "rm -rf ${env.WORKSPACE}/project"
                                }
                            }
                        }
                    }

            stage("deploy") {
                steps {
                    script {
                        dir("${env.WORKSPACE}/jars") {
                            sh "java -jar Rachael-0.0.1-SNAPSHOT.jar nohup &"
                        }
                    }
                }
            }
    }
}