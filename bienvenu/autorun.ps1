Remove-Item -LiteralPath "A:\Wildfly36\standalone\deployments\*.*"
Start-Process -FilePath "powershell" -WorkingDirectory ".\" -ArgumentList "mvn clean install -U" -NoNewWindow -Wait
Copy-Item -Path ".\bienvenuEar\target\bienvenuEar-0.0.1.ear" -Destination "A:\Wildfly36\standalone\deployments\"
Start-Process -FilePath "powershell" -ArgumentList "A:\Wildfly36\bin\standalone.ps1" -NoNewWindow -Wait