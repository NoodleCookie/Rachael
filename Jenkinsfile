pipeline {
  agent any
    stages {
        stage('hello') {
            steps{
                script{
                    println('hello')
                }
            }
        }

        stage('checkout') {
                    steps{
                                git 'https://github.com/NoodleCookie/Rachael.git'
                    }
                }
    }
}