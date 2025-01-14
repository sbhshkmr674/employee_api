pipeline {
    agent any
    stages {
        stage('Build : Maven Install') {
            steps {
                echo 'Building...'
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Maven Test') {
            steps {
                echo 'Testing...'
               sh 'mvn clean test'
            }
        }
        stage('Maven Package'){
            steps{
                echo 'Package Clean'
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
                // Add your deploy steps here
            }
        }
    }

    stage('Test') {
      steps {
        echo 'Testing...'
      }
    }

    stage('Deploy') {
      steps {
        echo 'Deploying...'
      }
    }

  }
}