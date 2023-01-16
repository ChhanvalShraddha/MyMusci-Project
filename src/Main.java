import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

       // System.out.println("Hello world!");
        public static List<Album> albums = new ArrayList<>();
        public static void main(String[] args) {

            Album album1 = new Album("Moosa", "Sidhu Moosewala");
            album1.addSongToAlbum("295", 4.05);
            album1.addSongToAlbum("LastRide", 5.5);
            album1.addSongToAlbum("So High", 3.05);

            Album album2 = new Album("Arijit's Songs", "Arijit Singh");
            album2.addSongToAlbum("Kesariya", 5);
            album2.addSongToAlbum("Jeena Jeena", 4.05);
            album2.addSongToAlbum("Gerua", 6);

            albums.add(album1);
            albums.add(album2);

            // System.out.println(album1.isfind("Gerua"));

            LinkedList<Song> myPlayList = new LinkedList<>();
            album1.AddSongToPlayListFromAlbum("295", myPlayList);
            album2.AddSongToPlayListFromAlbum("Kesariya", myPlayList);
            album1.AddSongToPlayListFromAlbum("So High", myPlayList);
            album2.AddSongToPlayListFromAlbum("Jeena Jeena", myPlayList);
            album1.AddSongToPlayListFromAlbum("LastRide", myPlayList);
            play(myPlayList);
        }
            public static void play(LinkedList<Song>playList ){
                ListIterator<Song> itr = playList.listIterator();
                Scanner sc=new Scanner(System.in);
                boolean isForward=false;
                if(playList.size()>0){
                    System.out.print("Currently playing: ");
                    System.out.println(itr.next());//playing first song of playlist;
                    isForward = true;
                }
                else{
                    System.out.println("PlayList is empty first add the song in you playlist");
                    return;
                    }
                System.out.println("Enter your choice");
                printMenu();
                boolean quite=false;
                while(!quite){
                    int choice=sc.nextInt();
                    switch (choice){
                        case 1:
                            if(isForward==false){
                                itr.next();
                                isForward = true;
                            }
                            if(itr.hasNext()){
                                System.out.println(itr.next());
                            }
                            else{
                                System.out.println("You have reached the end of the playlist");
                                isForward = false;//you have at end of end of the playlist so we cant move forward that is why set it to false
                            }
                            break;
                        case 2:
                            if(isForward==true){
                                itr.previous();
                                isForward = false;//that means we have moved back so we set isforward =false;
                            }
                            if(itr.hasPrevious()){
                                System.out.println(itr.previous());
                            }
                            else{
                                System.out.println("You are at the start of playlist");
                                isForward = true;//we can move forward bcaz we at start so it true;
                            }
                            break;
                        case 3:
                            if(isForward==true){
                                if(itr.hasPrevious()) {
                                    System.out.println(itr.previous());
                                    isForward = false;
                                }
                            }
                            else{
                                if(itr.hasNext()){ //here isforward= false meant we at backward so play next song and that is current song
                                    System.out.println(itr.next());
                                    isForward = true;
                                }
                            }
                            break;
                        case 4:
                            printMenu();
                            break;
                        case 5:
                            break;
                        case 6:
                            printSongs(playList);
                            break;
                        case 7:
                            quite = true;
                            break;
                    }

                }
                }
    public static void printSongs(LinkedList<Song> playList){
        for(Song song: playList)
            System.out.println(song);
        return;
    }



    public static void printMenu(){
        System.out.println("1 - Play next song");
        System.out.println("2 - Play previous song");
        System.out.println("3 - Repeat the current song");
        System.out.println("4 - Show menu again");
        System.out.println("5 - Delete the current song");
        System.out.println("6 - Print all the songs in playlist");
        System.out.println("7 - Exit");

        return;
    }

}