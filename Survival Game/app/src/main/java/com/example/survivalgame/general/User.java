package com.example.survivalgame.general;

import java.time.Duration;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable, Comparable<User> {
  /* user's password */
  private String password;

  /* user's nickname */
  private String nickname;

  /* indicate that whether the user has registered his/her score to the scoreboard */
  private boolean registered = false;

  /* user's current score */
  private int score;

  /* user's highest score */
  private int highestScore;

  /* user's current life count */
  private int life;

  /* the duration this user has played this game */
  private Duration totalDuration;

  /* the game the user is playing */
  private int gameStage;

  private List<List<List<Float>>> replay = new ArrayList<>();

  /* First game: Running game */
  public static final int RUNNING = 0;
  /* Second game: Pong game */
  public static final int PONG = 1;
  /* Last game: Dodge game */
  public static final int DODGE = 2;

  /**
   * instantiate the user. Set initial score to 0 and life count to 3
   *
   * @param username user's username
   * @param password user's password
   */
  public User(String username, String password) {
    this.password = password;
    this.nickname = username;
    score = 0;
    life = 3;
    gameStage = RUNNING;
    totalDuration = Duration.ofSeconds(0);
  }

  /** get the user's password */
  public String getPassword() {
    return password;
  }

  /** get the user's current score */
  public int getScore() {
    return score;
  }

  public void setNickname(String newNickname) {
    nickname = newNickname;
  }

  public boolean isRegistered() {
    return registered;
  }

  public void setRegistered() {
    registered = true;
  }

  /** set the user's highest score */
  public void updateHighestScore(int currentScore) {
    if (currentScore > highestScore) {
      highestScore = currentScore;
    }
  }

  /**
   * update the user's score
   *
   * @param newScore the user's new score
   */
  public void setScore(int newScore) {
    score = newScore;
  }

  /** get the user's current life count */
  public int getLife() {
    return life;
  }

  /**
   * update the user's life count
   *
   * @param newLife user's new life count
   */
  public void setLife(int newLife) {
    life = newLife;
  }

  /** get the game the user's currently playing */
  public int getGameStage() {
    return gameStage;
  }

  /**
   * update the game the user's currently playing
   *
   * @param newGameStage the game the player is playing
   */
  public void setGameStage(int newGameStage) {
    gameStage = newGameStage;
  }

  /** get the duration of user's playing time */
  public Duration getTotalDuration() {
    return totalDuration;
  }

  /**
   * update the duration of user's playing time
   *
   * @param newTotalDuration the new duration to be set
   */
  public void setTotalDuration(Duration newTotalDuration) {
    totalDuration = newTotalDuration;
  }

  public void clearReplay() {
    replay.clear();
  }

  public void reset() {
    life = 3;
    gameStage = User.RUNNING;
    score = 0;
    totalDuration = Duration.ofSeconds(0);
  }

  @Override
  public int compareTo(User user) {
    return Integer.compare(user.highestScore, this.highestScore);
  }

  public void addReplay(List<List<Float>> tempReplay) {
    this.replay.add(tempReplay);
  }

  public List<List<List<Float>>> getReplay() {
    return replay;
  }

  public void deleteReplay() {
    replay.remove(0);
  }

  public boolean isEmptyReplay() {
    return replay.isEmpty();
  }

  public void setReplay(List<List<List<Float>>> newReplay) {
    this.replay = newReplay;
  }

  @Override
  public String toString() {
    return "Player " + this.nickname + " receives " + highestScore + " scores";
  }
}
