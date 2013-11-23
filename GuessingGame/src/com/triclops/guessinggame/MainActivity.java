package com.triclops.guessinggame;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private TextView numberText, winnerText;
	private EditText p1Text, p2Text, p3Text, p4Text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		numberText = (TextView) findViewById(R.id.numberLabel);
		winnerText = (TextView) findViewById(R.id.winnerLabel);
		p1Text = (EditText) findViewById(R.id.p1Text);
		p2Text = (EditText) findViewById(R.id.p2Text);
		p3Text = (EditText) findViewById(R.id.p3Text);
		p4Text = (EditText) findViewById(R.id.p4Text);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void gButtonClick(View view) {
		final String p1Value = p1Text.getText().toString();
		final String p2Value = p2Text.getText().toString();
		final String p3Value = p3Text.getText().toString();
		final String p4Value = p4Text.getText().toString();
		final int rNumber = Guess.randomInteger(1, 20);
		final int winner = Guess.getWinner(p1Value, p2Value, p3Value, p4Value, rNumber);
		numberText.setText(getResources().getString(R.string.numText) + " " + Integer.toString(rNumber));
		winnerText.setText(getWinText(winner) + " " + getResources().getString(R.string.wins));
	}
	
	public String getWinText(int id) {
		String winner = null;
		if (id == 1) {
			winner = getResources().getString(R.string.player1_title);
		}
		if (id == 2) {
			winner = getResources().getString(R.string.player2_title);
		}
		if (id == 3) {
			winner = getResources().getString(R.string.player3_title);
		}
		if (id == 4) {
			winner = getResources().getString(R.string.player4_title);
		}
		return winner;
	}

}
