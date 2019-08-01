insert into news (title, body, created_on, news_img) values 
	('Punch and Pi: Round One', 
		'<i>Welcome to Punch & Pi!</i>  I created this site to give me a platform to express and exercise my interests in tech, namely embedded systems, using awesome tools like the Raspberry Pi and Arduino boards.  
<br>
<p>
So, what is here now?  Head over to the “Projects” page to have a look at what I’m working on.  Various DIY projects, or experimentation on tech-related topics are on there right now.
<br>
<p>
And what about the future?  Well that is more long-winded, but in short, I’ve got plans to offer a “Shop” section where some of the DIY projects can be purchased (for the less tech savvy), and perhaps actively pursue projects in tech, and even in the automotive world.  Although my education is in tech, most of my childhood was spent in obsession with hot rods, muscle cars, and other four-wheeled, overpowered vehicles.  
<br>
<p>
Thanks for stopping by!  Shoot me an email with any suggestions:  <a href="mailto:mkellynola@gmail.com?Subject=Site%20Suggestions" target="_top">mkellynola@gmail.com</a> 
', 
'2018-2-25', 
'src/main/resources/db/migration/roundone.png'),

('Happy Pi-Day!  New Raspberry Pi B+ Announced!',
'In celebration of International Pi Day, the Raspberry Pi team announced a new unit immediately available – the Raspberry Pi 3 Model B+.  About two years ago, the Pi 3 was released, featuring a 1.2Ghz dual-core, Broadcom 64-bit CPU, 40 GPIO, 4 USB ports, WLAN connectivity, Bluetooth, and a few other excellent features.  It was a resounding success – per their official site, they’ve sold over 9 million of the Pi 3’s.  
<p>
<i>What’s different here in the new B+?  </i>First, let me mention, the footprint is identical to the B model.  It will be a direct replacement for any project you currently have an unmodified B – but some titillating upgrades have been made.  
<p>
First, the CPU has been changed to an ARM Cortex-A53, 1.4Ghz dual-core unit.  Additional upgrades to the computer’s thermal management has raspberrypi.org claiming to be able to outperform the original B’s computational power for longer periods.  In short, you can do a lot more work on the Pi 3 B+ without worrying if overheating is reducing clock cycles.  
<p>
The wireless and network capabilities have seen the biggest bolster in performance.  This newest model includes an updated dual-band wireless LAN and Bluetooth chip.  The update enhances the B+ for 5Ghz WiFi connectivity, a feature unavailable on the previous Pi 3 B without an additional wifi dongle.  Official testing shows a slight improvement over the last model’s conventional 2.4Ghz network connection.  
<p>
Upgrades to the Ethernet Hub and controller for the B+ now supports Gigabit Ethernet.  While the throughput (due to application processor limits) is not at the full-capacity of Gigabit eth., it does test nearly 3 times the throughput of the prior Pi 3 B.   
<p>
With these exciting updates, you may be wondering “Are the older models still being supported and distributed?”  And the answer is yes, according the Pi guys, industrial demand of the older models is still high.  I will be ordering a unit soon for an upcoming home security project, and I’ll be sure to update with some pics and a personal review.',
'2018-03-14',
'src/main/resources/db/migration/pi3bplus.png');