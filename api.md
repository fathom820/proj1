# API

Player calls program with 1 of 2 arguments:

    - `-h` starts game as host (will run client and server, possibly different threads?)
    - `-c [ip]` connects to an existing host on port 4446 (will run only client)

- Host will be made X, guest will be made O
- X will go first

Board format:
```
* A B C
1 + + +
2 + + +
3 + + +
```

(Star and plus are placeholders)

---

1. Print board (both clients)
2. When one player is taking their turn, it will tell them to enter in the correct format;
   for the other player, it will say "X/O is taking their turn"
3. Print updated board (both clients)
4. Repeat until a player wins or disconnects