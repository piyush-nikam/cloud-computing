from pubnub.callbacks import SubscribeCallback
from pubnub.enums import PNStatusCategory,PNReconnectionPolicy
from pubnub.pnconfiguration import PNConfiguration
from pubnub.pubnub import PubNub
from pprint import pprint
import threading

class MySubscribeCallback(SubscribeCallback):
    def status(self, pubnub, status):
        pass

    def presence(self, pubnub, presence):
        pprint(presence.__dict__)

    def message(self, pubnub, message):
        direction = message.__dict__['message']['content']
        print('Bot is moving: ', direction)
        global stop_threads = True
        move_bot(direction)


def move_bot(direction):
    #threading.Thread(target = fun1, args = direction)
    global stop_threads = False
    if(direction=='left'):
        t1 = threading.Thread(target = move_bot_left(), args = direction)
        t1.start()
    elif(direction=='right'):
        t2 = threading.Thread(target = move_bot_right(), args = direction)
        t2.start()
    elif(direction=='forward'):
        move_bot_forward()
    elif(direction=='backward'):
        move_bot_backward()
    elif(direction=='stop'):
        move_bot_stop()

def move_bot_left():
    white(True):
        print('going left with stop_threads', stop_threads)
        global stop_threads 
        if stop_threads: 
            break
    return

def move_bot_right():
    print('going right')
    return

def move_bot_forward():
    print('going forward')
    return

def move_bot_backward():
    print('going backward')
    return

def bot_stop():
    print('stopping')
    return


pnconfig = PNConfiguration()
pnconfig.subscribe_key = "sub-c-918b08b4-0c33-11ea-a783-52dd774e953e"
pnconfig.publish_key = "pub-c-25f3d76c-b9ae-414c-951e-adcf71ef4335"
pnconfig.reconnect_policy = PNReconnectionPolicy.LINEAR

pubnub = PubNub(pnconfig)

pubnub.add_listener(MySubscribeCallback())

pubnub.subscribe().channels("pubnub_onboarding_channel").with_presence().execute()