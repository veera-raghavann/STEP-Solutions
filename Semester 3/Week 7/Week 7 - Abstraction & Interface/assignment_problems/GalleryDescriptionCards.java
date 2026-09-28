public class GalleryDescriptionCards {
    static abstract class ArtPiece {
        private static int nextId = 1001;
        private final String pieceId;
        private final String title;

        protected ArtPiece(String title) {
            if (title == null || title.isBlank()) throw new IllegalArgumentException("title cannot be blank");
            this.title = title;
            this.pieceId = "ART-" + nextId++;
        }

        public abstract String describe();
        public String getPieceId() { return pieceId; }
        protected String getTitle() { return title; }
    }

    static class Painting extends ArtPiece {
        public Painting(String title) { super(title); }
        @Override public String describe() { return "Painting: " + getTitle() + ", framed on canvas"; }
    }

    static class Sculpture extends ArtPiece {
        public Sculpture(String title) { super(title); }
        @Override public String describe() { return "Sculpture: " + getTitle() + ", carved from stone"; }
    }

    public static void main(String[] args) {
        Painting p = new Painting("Sunset Fields");
        Sculpture s = new Sculpture("The Thinker II");
        System.out.println(p.describe());
        System.out.println(s.describe());
        System.out.println(p.getPieceId());
        System.out.println(s.getPieceId());
    }
}
