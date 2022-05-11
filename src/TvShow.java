public class TvShow {
  private String name;
  private int episodes;
  private String genre;

  public TvShow(String name, int episodes, String genre) {
    this.name = name;
    this.episodes = episodes;
    this.genre = genre;
  }

  public String getName() {
    return name;
  }

  public int getEpisodes() {
    return episodes;
  }

  public String getGenre() {
    return genre;
  }

  @Override
  public String toString() {
    return "%s, %s, %d episodes"
      .formatted(getName(), getGenre(), getEpisodes());
  }
}
