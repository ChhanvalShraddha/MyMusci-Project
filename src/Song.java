public class Song {
     private String Title;
     private double Duration;

    public Song(String Title, double Duration ){
        this.Title=Title;
        this.Duration=Duration;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public double isDuration() {
        return Duration;
    }

    public void setDuration(double duration) {
        Duration = duration;
    }

    @Override
    public String toString() {
        return "Song{" +
                "Title='" + Title + '\'' +
                ", Duration=" + Duration +
                '}';
    }
}
