pipeline {
	agent any

	environment {
		NAME = 'newbie'
	}

	stages {
		stage('build') {
			steps {
				sh 'echo "Say something"'
				sh '''
					echo "Multiline shell steps works too"
					ls -lah
				'''
			}
		}
		stage('deploy') {
			steps {
				timeout(time: 3, unit: 'MINUTES') {
					retry(5) {
						sh 'echo "retry ++"'
					}
				}
			}
		}
		stage('environment') {
			steps {
				sh 'echo "show name: $NAME"'
			}
		}
	}
	post {
		always {
			echo 'This will always run'
		}
		success {
			echo 'This will run only if successful'
		}
		failure {
			echo 'This will run only if failed'
		}
		unstable {
			echo 'This will run only if the run was marked as unstable'
		}
		changed {
			echo 'This will run only if the state of the Pipeline has changed'
			echo 'For example ion the Pipeline was previously failing but is now successful'
		}
	}
}