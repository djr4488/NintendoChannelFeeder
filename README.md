Nintendo Channel Feeder
=======================

Preserve the functionality of some of the Wii channels; Forecast, News, and Everybody Votes

Initial goal
------------

Just send the files that have been already captured and check out the Wii calls out to get those files.  This is done.

Mid goal
--------

This actually becomes a bit harder, but change data in the files and see how the Wii reacts.  What does it validate.

Long term goal
--------------

Create the files and feed new information to the channels.  Some games take advantage of this information 
and it would be nice to get the full functionality of these games working again.

What probably needs to be done?
-------------------------------

Brushing up on assembly and understanding the file format of these channels.

Figuring out how to fake an RSA signature or create it.  Likely without the help of Nintendo.  Would be nice if 
they would open source that or something silly.  

Calling out to either RSS feeds or APIs to get required data for news and forecasts.  Creating services to handle question submisssions and moderating those questions before they can be "displayed".

How to run this?
----------------

I am using TomEE.  But there shouldn't be any reason to set this up and run it using any other container like Glassfish or Wildfly.

How can you help?
-----------------

Know someone who works at Nintendo who can legally provide information about the file formats for the channels and legally share the RSA key to sign the files with?  Well that would be great!

Beyond that, helping to figure this stuff out by hand would be a plus as well.

Why do this?
------------

It wasn't used much by many people I am sure, which is probably what prompted Nintendo to shut it down.  But it was used by me as a way to connect with my kids at a level that was to their understanding.

I'd still like to do use this as a way to spark their imagination in things like science(forecast channel works for that), news and politics(and the news channel worked for that), and opinions.

Why did these channels work so well?  They were simple, colorful, and entertaining for them, and so preserving their functionality is important to me.  So if you want to help fork the project and contribute.

If you work at Nintendo, well that would be cool as well if you can help.

Other info
----------

https://github.com/djr4488/NintendoChannelFeeder/wiki/Extra-Information

Questions?
----------

I can be emailed at tureli_do (at) hotmail (dot, just one dot) com
