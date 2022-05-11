public class Book {
  private String title;
  private int pages;
  private int published;

  public Book(String title, int pages, int published) {
    this.title = title;
    this.pages = pages;
    this.published = published;
  }

  public String getTitle() {
    return title;
  }

  public int getPages() {
    return pages;
  }

  public int getPublished() {
    return published;
  }

  @Override
  public String toString() {
    return "%s, %d, %d pages"
        .formatted(getTitle(), getPublished(), getPages());
  }
}
