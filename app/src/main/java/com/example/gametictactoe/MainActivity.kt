    package com.example.gametictactoe
    
    
    import android.annotation.SuppressLint
    import android.content.Context
    import android.media.MediaPlayer
    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import android.view.View
    import android.widget.Button
    import android.widget.TextView
    import android.widget.Toast
    import kotlinx.android.synthetic.main.activity_main.*
    
    class MainActivity : AppCompatActivity() {
    
        var flag = 0
        var count = 0
        lateinit var userTurn: TextView
        lateinit var player1score : TextView
        lateinit var player2score : TextView
        lateinit var mediaPlayer_winning: MediaPlayer
        lateinit var mediaPlayer_x_o_btn: MediaPlayer

        // Player Score
        private var player1point : Int = 0
        private var player2point : Int = 0

        // music state
        private var musicState = false
    
        @SuppressLint("SetTextI18n", "MissingInflatedId")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            userTurn = findViewById(R.id.textView)
    
            // fun for players name and score
            player1score = findViewById(R.id.player1nameandscore)
            player2score = findViewById(R.id.player2nameandscore)

            // Set the initial scores
            player1score.text = "Player 1 (X) : $player1point"
            player2score.text = "Player 2 (O) : $player2point"

            // get shared-preference for music on/off
            val sharedPreferences = getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE)
            musicState = sharedPreferences.getBoolean("music_state", true)

            // Initialize the MediaPlayers
            mediaPlayer_winning = MediaPlayer.create(this, R.raw.win_music)
            mediaPlayer_x_o_btn = MediaPlayer.create(this, R.raw.x_o_sound)

    
        }
    
        @SuppressLint("SetTextI18n")
        fun check(view : View) {
            val currentBtn = view as Button
            count++
    
            if(flag==0){
                userTurn.text = "Turn : 0"
            } else if(flag == 1) {
                userTurn.text = "Turn : X"
            }
    
    
            if (currentBtn.text == "") {
    
                //Taking user input if first time click then X -> then O -> repeat
                if (flag == 0) {
                    currentBtn.text = "X"
                    flag = 1
                    if(musicState) {
                        mediaPlayer_x_o_btn.start()
                    }
    
                } else {
                    currentBtn.text = "O"
                    flag = 0
                    if(musicState) {
                        mediaPlayer_x_o_btn.start()
                    }
                }
    
                // storing all button States
                val b1 = btn1.text.toString()
                val b2 = btn2.text.toString()
                val b3 = btn3.text.toString()
                val b4 = btn4.text.toString()
                val b5 = btn5.text.toString()
                val b6 = btn6.text.toString()
                val b7 = btn7.text.toString()
                val b8 = btn8.text.toString()
                val b9 = btn9.text.toString()
    
                // Conditions for winning
    
                if(count>4){
    
                    if (b1 == b2 && b2 == b3 && b1 != "" && b2 != "") {
                        Toast.makeText(this, "Winner is $b1", Toast.LENGTH_SHORT).show()
                        userTurn.text = "Winner : $b1"
    //                    newGame()
                        whichPlayerScore(b1)
                        if(musicState) {
                            mediaPlayer_winning.start()
                        }
                        checkScore()
                        stopMatch()
    
                    } else if (b4 == b5 && b5 == b6 && b4 != "" && b5 != "") {
                        Toast.makeText(this, "Winner is $b4", Toast.LENGTH_SHORT).show()
                        userTurn.text = "Winner : $b4"
    //                    newGame()
                        whichPlayerScore(b4)
                        if(musicState) {
                            mediaPlayer_winning.start()
                        }
                        checkScore()
                        stopMatch()
    
                    } else if (b7 == b8 && b8 == b9 && b7 != "" && b8 != "") {
                        Toast.makeText(this, "Winner is $b7", Toast.LENGTH_SHORT).show()
                        userTurn.text = "Winner : $b7"
                        whichPlayerScore(b7)
                        if(musicState) {
                            mediaPlayer_winning.start()
                        }
                        checkScore()
                        stopMatch()
    
                    } else if (b1 == b4 && b4 == b7 && b1 != "" && b4 != "") {
                        Toast.makeText(this, "Winner is $b1", Toast.LENGTH_SHORT).show()
                        userTurn.text = "Winner : $b1"
                        whichPlayerScore(b1)
                        if(musicState) {
                            mediaPlayer_winning.start()
                        }
                        checkScore()
                        stopMatch()
    
                    } else if (b2 == b5 && b5 == b8 && b2 != "" && b5 != "") {
                        Toast.makeText(this, "Winner is $b2", Toast.LENGTH_SHORT).show()
                        userTurn.text = "Winner : $b2"
                        whichPlayerScore(b2)
                        if(musicState) {
                            mediaPlayer_winning.start()
                        }
                        checkScore()
                        stopMatch()
    
                    } else if (b3 == b6 && b6 == b9 && b3 != "" && b6 != "") {
                        Toast.makeText(this, "Winner is $b3", Toast.LENGTH_SHORT).show()
                        userTurn.text = "Winner : $b3"
                        whichPlayerScore(b3)
                        if(musicState) {
                            mediaPlayer_winning.start()
                        }
                        checkScore()
                        stopMatch()
    
                    } else if (b1 == b5 && b5 == b9 && b1 != "" && b5 != "") {
                        Toast.makeText(this, "Winner is $b1", Toast.LENGTH_SHORT).show()
                        userTurn.text = "Winner : $b1"
                        whichPlayerScore(b1)
                        if(musicState) {
                            mediaPlayer_winning.start()
                        }
                        checkScore()
                        stopMatch()
    
                    } else if (b3 == b5 && b5 == b7 && b3 != "" && b5 != "") {
                        Toast.makeText(this, "Winner is $b3", Toast.LENGTH_SHORT).show()
                        userTurn.text = "Winner : $b3"
                        whichPlayerScore(b3)
                        if(musicState) {
                            mediaPlayer_winning.start()
                        }
                        checkScore()
                        stopMatch()
    
                    }else if(count==9){
                        Toast.makeText(this, "Match is Draw", Toast.LENGTH_SHORT).show()
                        userTurn.text = "Match Draw"

                    }
    
                }
            }
        }

        // fun for checking which player is win
        private fun whichPlayerScore(a : String){
            if(a == "X"){
                this.player1point++
            }else{
                this.player2point++
            }
        }

        // function for updating player scores
        @SuppressLint("SetTextI18n")
        private fun checkScore(){
            player1score.text = "Player 1 (X) : $player1point"
            player2score.text = "Player 2 (O) : $player2point"
            scoreDisplay.text = "$player1point : $player2point"
        }
    
        fun restatingMatch(view: View){
            restartGame()
        }

        // function for restarting score to zero
        @SuppressLint("SetTextI18n")
        fun restartScore(view: View){
            startMatch()
            scoreDisplay.text = "0 : 0"
            player1score.text = "Player 1 (X) : 0"
            player2score.text = "Player 2 (O) : 0"
            player1point = 0
            player2point = 0
            restartGame()
        }

        // function for what to do on restart
        @SuppressLint("SetTextI18n")
        private fun restartGame(){
            startMatch()
            btn1.text = ""
            btn2.text = ""
            btn3.text = ""
            btn4.text = ""
            btn5.text = ""
            btn6.text = ""
            btn7.text = ""
            btn8.text = ""
            btn9.text = ""
            flag = 0
            count = 0
            userTurn.text = "Turn : X"
    
    
        }

        // function for stop match
        private fun stopMatch(){
            btn1.isEnabled = false
            btn2.isEnabled = false
            btn3.isEnabled = false
            btn4.isEnabled = false
            btn5.isEnabled = false
            btn6.isEnabled = false
            btn7.isEnabled = false
            btn8.isEnabled = false
            btn9.isEnabled = false
        }

        // function for start match
        private fun startMatch(){
            btn1.isEnabled = true
            btn2.isEnabled = true
            btn3.isEnabled = true
            btn4.isEnabled = true
            btn5.isEnabled = true
            btn6.isEnabled = true
            btn7.isEnabled = true
            btn8.isEnabled = true
            btn9.isEnabled = true
        }

    }