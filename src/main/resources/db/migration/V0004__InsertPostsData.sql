insert into posts (title, body, created_on, post_img) values 
('Shove It Up Your Pi-Hole!', 'Initially, this was an experiment I designed for a Securities class that I conducted with two of my close friends & classmates, Aileen Do and Stephen Jackson.  <i>The idea? </i> To use a Raspberry Pi as a network advertisement blocker, using open-source <strong>Pi-Hole</strong> software, and measure the performance results.  
<br>
<p>However, it was an unusual test using a Samsung Smart TV that piqued our interests.  
<p>
This free, open-source software converts your Raspberry Pi into an ad-blocker for every device connected to your Wi-Fi – every phone, tablet, computer, console, or Smart TV can all simultaneously benefit from implementing your Pi with the Pi-Hole software.  Additionally, all Pi-Hole functionality and logging can be accessed via a very pleasant UI.  
<p>

<p>
How Does It Work?
<p>
When you access a web page, or stream through an application, a web connection is established between your device (client) and the service (host).  Embedded in that web page or application may be more code to instruct your client-device to request other resources (like advertisements) from another host (ad-hosting service or domain).  The Pi-Hole software works by acting as a DNS (Domain Name Service) for all outgoing requests through your Wi-Fi network.  If any of these requests are in the list of 100,000+ known ad-hosting domains – the request is blocked.  Your device & network will never have to waste bandwidth on downloading the ad in the first place.  The web user-interface (shown) allows the user to log web requests on their network, whitelist/blacklist specific domains, or disable the services at-will.  
<p>
Performance Measurements:
<p>
Load Time:  Tested with Google Chrome developer’s tools.  You can see compared to normal (no Pi-Hole active), the average load-time of the tested web-pages is nearly cut down to 1/3rd.  In short, it is MUCH faster to use the Pi-Hole.  
<p>
{{Load Time}}
<p>




Number of Requests:  Tested with Pi-Hole’s log, visible through the Web UI.  The graph shows the number of requests successfully completed with no software versus with Pi-Hole.  This correlates the data shown in load times.  In some web applications, nearly half of the requests were ad-related.
<p>
{{Numrequest}} 
{{Weather Channel Pic}} 
<p>
Smart TVs (Samsung, at the very least):
<p>
I’m going to single-out Samsung here.  As you can see in the image, Samsung cloud services does more than its fair share of “listening” – over 85% of all traffic through the Samsung Smart TV was related to Samsung cloud services.  I’m not even sure what most of the traffic is related to – but no loss of functionality was experienced when the Pi-Hole was active.  Seems like extremely irresponsible use of data mining from the hands of Samsung on this one.  I can hardly justify 85+% of a streaming device to utilize its network presence to submit user information back to its cloud network.  Maybe someone with more information can enlighten me.   
<p>

I may do a write-up on setting one up, along with videos of what the changes are like – if there’s enough interest.  In the meantime, checkout Pi-Hole and feel free to shoot me an email with any feedback on this project, or if you’d like a How-To on setting up the Pi-Hole.  
<p>

https://pi-hole.net ', '2018-01-03', 'src/main/resources/db/migration/pihole.png'),



('mintyPi:  Refreshen your breadth (of retro games)', 
	'The <i>mintyPi</i>: one of the coolest Pi projects to-date, and encompasses so many crucial skills related to computer sciences, electrical engineering, materials & design, soldering, testing – the list goes on and on.  
<p>
<i>The idea?</i>  Build a portable emulator gaming console using a Pi-Zero, housed all inside of a classic Altoids breathmint metal case.  Pretty.  Freakin’.  Sweet.  The mainstream build includes a proprietary PCB (printed circuit board) design by Wermy (sudomod.com) and a screen/PCB combo by Helder, 3D printed parts from Wermy, a USB sound card/ small speaker, heck, it even has L/R button inputs.  I can’t play this thing in public without getting bombarded with curiosities and questions.  
<br>
<p>
<b>Difficulty Rating:  6 out 10</b> 
<p> 1st:  There is a considerable amount of work to do, fine soldering for the PCB, and prep-work for the Altoids tin.  2nd, if you were lucky enough to get a Helder screen, you’ll probably know from experience that getting the ribbon cable <i>JUST</i> right can be tricky.  It took me a solid 30-45 minutes of testing, slight adjustment, and retesting before the screen was functioning correctly.  Beyond that, there was a little back and forth with making sure the wires were trimmed as short as possible to allow as much room inside the Altoids tin.  If your experience with soldering is minimal, and/or your experience with Raspberry Pi setup & terminal commands is lacking, then please do yourself a favor – have someone experienced assemble it.  
<br>
<p>
<b>Room for Improvement?</b>
<p>
Analog Stick > Old-school D-pad:  This problem I’ve only really found relevant in the fighters like Street Fighter II where Ryu’s Hadoken requires a diagonal input – but the mintyPi uses the Pi’s GPIO pins for traditional Up, Down, Left, Right inputs.  I was able to throw a Hadoken but not easily.  You could theoretically add an analog stick, but it would require some sort of connection to the micro USB port, and space is a major factor for the mintyPi.
<br>
<p>
AUX Headphone Jack:  Mods already exist to add this, and I’ll try to remember to add the link here.  It requires a little extra wire & soldering, and modifications to the Altoids tin but it is possible
<br>
<p>

Helder Screen Angle Visbility:  The v1.Helder screen, albeit crisp, has a very limited viewing angle.  The v2 Helder screen/pcb coming next is supposed to have improved ribbon cable connection, and a larger viewing angle.  
<br>
<p>

Either way, the project was a blast and provides a solid 3 hours of gameplay on the 1200mah Adafruit battery.  In case you were wondering, head over to <a href=”http://www.sudomod.com”>sudomod.com</a> and join their forums, peek around their marketplace, and stay tuned for the release of the v2 screen+pcb.  The parts go very quickly, so be ready to order or even preorder whenever possible!  -Mike
',
	'2018-02-01', 
	'src/main/resources/db/migration/mintypi.png');