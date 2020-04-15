
This project explains how to integrate your cucumber framework with docker-selenium-hub

1) To pull selenium-hub image:
docker pull selenium-hub

2) To pull chrome browser image:
docker pull selenium/node-chrome-debug

3) To pull firefox browser image:
docker pull selenium/node-firefox-debug

Once we pull all the images, then configure the selenium-hub and expose docker port to local port to access grid and console

4) To configure selenium-hub:
docker run -d -p 4444:4444 --name selenium-hub selenium/hub

5) To integrate node (chrome) with selenium-hub: 
 docker run -d --link selenium-hub:hub selenium/node-chrome-debug
 
6) To integrate node (firefox) with selenium-hub: 
 docker run -d --link selenium-hub:hub selenium/node-firefox-debug
 
7) Then create desiredcapabilities and use remotewebdriver to execute:
DesiredCapabilities cap=
				DesiredCapabilities.chrome();
				cap.setCapability("version", "");
				cap.setCapability("platform", "LINUX");
				driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
				driver.get("url");
 
This Project is created to integrate Extent Report.
The reference taken from vimalselvam git repo: https://github.com/email2vimalraj/CucumberExtentReporter



git remote add origin https://github.com/kprasadbio/docker-selenium-hub.git 