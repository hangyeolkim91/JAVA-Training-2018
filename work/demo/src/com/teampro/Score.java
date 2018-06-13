package com.teampro;

import java.awt.TextArea;

public interface Score {

	public void init();
	public void input();
	public void input(ScoreVO vo);
	public void saveAndExit();
	public void print();
	public void print(TextArea ta);
}
