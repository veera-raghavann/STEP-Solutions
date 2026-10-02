public class GalleryDescriptionCards {

    static abstract class ArtPiece {
        private static int nextId = 1001;
        private final String pieceId;
        private final String title;

        protected ArtPiece(String title) {
            this.title = title;
            this.pieceId = "ART-" + nextId++;
        }

        public abstract String describe();

        public String getPieceId() {
            return pieceId;
        }

        protected String getTitle() {
            return title;
        }
    }

    static class Painting extends ArtPiece {
        Painting(String title) {
            super(title);
        }

        public String describe() {
            return "Painting: " + getTitle() + ", framed on canvas";
        }
    }

    static class Sculpture extends ArtPiece {
        Sculpture(String title) {
            super(title);
        }

        public String describe() {
            return "Sculpture: " + getTitle() + ", carved from stone";
        }
    }

    public static void main(String[] args) {
        Painting painting = new Painting("Sunset Fields");
        Sculpture sculpture = new Sculpture("The Thinker II");

        System.out.println(painting.describe());
        System.out.println(sculpture.describe());
    }
}
