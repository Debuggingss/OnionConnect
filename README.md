# OnionConnect
Proof of concept Minecraft mod that allows connections to .onion servers.

### Usage (For Windows)
1) Run `tor.exe` using `tor.exe | more`. It will be in `<Tor Install Path>\Tor Browser\Browser\TorBrowser\Tor` directory.
2) Run the game with the mod.
3) Go to Multiplayer and check the `Toggle Tor Proxy` checkbox in the top left corner.
4) Now you can join .onion servers.
5) Have fun playing on 2000 ping!

**Joining non-onion servers with the proxy on will have the same effect as using a VPN. Use with caution.**

### Hosting a server on Tor
Simply make a hidden service on port `25565`. I won't be covering that here as there are plenty of tutorials on setting up hidden services already and `torrc` should have examples as well. 

Huge thanks to DJtheRedstoner for helping me with the Mixins.

**Warning: This mod breaks Essential's Singleplayer sharing feature!**
