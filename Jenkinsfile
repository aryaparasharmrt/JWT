pipeline {
    agent any

    tools {
        jdk 'JDK-21'
        maven 'Maven-3.9'
    }

    stages {

        stage('Check Java Version') {
            steps {
                sh 'java -version'
            }
        }

        stage('Checkout') {
            steps {
                git 'https://github.com/aryaparasharmrt/JWT.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }

        stage('Run') {
            steps {
                sh 'java -jar target/*.jar &'
            }
        }
    }
}
us