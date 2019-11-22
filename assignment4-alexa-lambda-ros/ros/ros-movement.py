from pubnub.callbacks import SubscribeCallback
from pubnub.enums import PNStatusCategory
from pubnub.pnconfiguration import PNConfiguration
from pubnub.pubnub import PubNub
from pprint import pprint

class MySubscribeCallback(SubscribeCallback):
    def status(self, pubnub, status):
        pass

    def presence(self, pubnub, presence):
        pprint(presence.__dict__)

    def message(self, pubnub, message):
        direction = message.__dict__['message']['content']
        pprint('Bot is moving: ', direction)
        move_bot(direction)


def move_bot(direction):
    if(direction=='left'):
        move_bot_left()
    elif(direction=='right'):
        move_bot_right()
    elif(direction=='forward'):
        move_bot_forward()
    elif(direction=='backward'):
        move_bot_backward()
    elif(direction=='stop'):
        move_bot_stop()

def move_bot_left():
    return

def move_bot_right():
    return

def move_bot_forward():
    return

def move_bot_backward():
    return

def bot_stop():
    return


pnconfig = PNConfiguration()
pnconfig.subscribe_key = "sub-c-918b08b4-0c33-11ea-a783-52dd774e953e"
pnconfig.publish_key = "pub-c-25f3d76c-b9ae-414c-951e-adcf71ef4335"

pubnub = PubNub(pnconfig)

pubnub.add_listener(MySubscribeCallback())

pubnub.subscribe().channels("pubnub_onboarding_channel").with_presence().execute()