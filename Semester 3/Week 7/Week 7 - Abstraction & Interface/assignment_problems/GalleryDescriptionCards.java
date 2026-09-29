public class GalleryDescriptionCards {
    static abstract class ArtPiece{private static int nextId=1001;private final String pieceId,title;protected ArtPiece(String t){title=t;pieceId="ART-"+nextId++;}public abstract String describe();public String getPieceId(){return pieceId;}protected String getTitle(){return title;}}
    static class Painting extends ArtPiece{Painting(String t){super(t);}public String describe(){return "Painting: "+getTitle()+", framed on canvas";}}
    static class Sculpture extends ArtPiece{Sculpture(String t){super(t);}public String describe(){return "Sculpture: "+getTitle()+", carved from stone";}}
    public static void main(String[] args){Painting p=new Painting("Sunset Fields");Sculpture s=new Sculpture("The Thinker II");System.out.println(p.describe());System.out.println(s.describe());}
}