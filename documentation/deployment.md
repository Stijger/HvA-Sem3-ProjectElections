# Deployment documentation

## General information
- Domain: stijngerkema.nl
- Frontend port: 80
- Backend port: 8080

## Frontend deployment
The frontend has been deployed onto a raspberry pi, port 80 has been forwarded to be accessed from anywhere. It is hosted on an apache web server, using a PI OS linux based operating system.

## Backend deployment
The backend has been deployed onto a ubuntu linux server. It runs via a jar file you can import through FTP.

## Setup instructions
### Frontend
- First of all, build the project using "npm run build"
- Open an FTP client to ssh onto the server with the following credentials
- host: stijngerkema.nl
  user: elections
  pw: elections@sem3
  port: 22
- Next, navigate to the following path on the server: "/var/www/html", and drag and drop the files from the "dist" folder in your project.

### Backend
- Navigate to the menu in intellij, and press build.
- Click on build artifacts.
- Now you see the artifact of the backend, press build/rebuild. Depending on if you have already built it before
- Now use the FTP client again with the same credentials as with the frontend.
- navigate to the folder "/var/www/backend".
- Drop the jar file that has been created in your "out" folder, into the "backend" folder.

## Starting the backend
- Open an SSH terminal (I.E. PuTTY).
- login with the elections credentials.
- enter the following command to start the backend:
```bash
systemctl start electionsbackend
```
- If you have made changes to the backend and replaced the file, use the following command:
```bash
systemctl restart electionsbackend
```
- If you wish to stop the backend, run the following command:
```bash
systemctl stop electionsbackend
```
