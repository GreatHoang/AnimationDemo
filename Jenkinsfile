pipeline {
	agent any
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
		stage('deploy) {
			steps {
				retry(3) {
					sh './flakey-deploy.sh'
				}

				timeout(time: 3, unit: 'MINUTES') {
					sh './health-check.sh'
				}
			}
		}
	}
}