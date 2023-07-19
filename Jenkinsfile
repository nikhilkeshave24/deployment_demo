pipeline {
    agent any
    environment {
    DOCKER_HUB_CREDENTIALS = credentials('dockerhubcred')
    }

    stages {
       stage('Initialization') {
            steps {
                git credentialsId: '599ac700-c0e5-447a-81df-effa47c4a00d', url: 'https://github.com/Rijas11/deployment_demo.git', branch: 'Dev'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn -f deployment_application/pom.xml clean install'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'sudo docker build . -t rijas1508/myapp:$BUILD_NUMBER'
            }
        }
	stage('Run Image') {
            steps {
                sh 'sudo docker run -p 9090:8080 rijas1508/myapp:$BUILD_NUMBER'
		echo 'Docker Deployment done..'
            }
        }
        stage('Docker Login') {
           // steps{                       	
	//			sh 'echo $DOCKERHUB_CREDENTIALS_PSW | sudo docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'                		
	//			echo 'Login Completed'      
		//	} 
		 steps {
                echo 'Docker Login..'
            }
        }
        stage('Docker Push') {
            steps {
              //  sh 'sudo docker push demo/deployment_application:1.0.0'
		    echo 'Docker Push..'
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