#Docker Details

## Running Development server  

- create network with a specified gateway  
- add that gateway ip to /etc/hosts with the alias of api.teammanage.nolansherman.com  
- generate the base image and the dev image
- set up container with the following command.:
	$'sudo docker run --network team_manage_network --name tm-dev -p 80:8080 -it -v /home/nolan/git/team-manager/backend/:/app/main team-manage-dev'
