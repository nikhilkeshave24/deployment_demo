pipeline {
    agent any
    environment {
    DOCKER_HUB_CREDENTIALS = credentials('doc-credentials')
    }

    stages {
       stage('Initialization') {
            steps {
                git 'https://github.com/nikhilkeshave24/deployment_demo.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'docker build -t demo/deployment_application:1.0.0 .'
            }
        }
        stage('Docker Login') {
            steps {
                sh 'docker login -u Rijas1508 --password '
            }
        }
        stage('Docker Push') {
            steps {
                sh 'docker push demo/deployment_application:1.0.0'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }  
    post {
    	always {
    		sh 'docker logout'    	
    	}  
    }
}