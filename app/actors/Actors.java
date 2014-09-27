package actors;


import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import play.Application;
import play.Play;
import play.Plugin;
import play.libs.Akka;

/**
 * Lookup for actors used by the web front end.
 */
public class Actors extends Plugin {

    private static Actors actors() {
        return Play.application().plugin(Actors.class);
    }

    public static ActorRef tweetServiceClient() {
        return actors().tweetServiceClient;
    }

    private final Application app;

    private ActorRef tweetServiceClient;

    public Actors(Application app) {
        this.app = app;
    }

    public void onStart() {
        ActorSystem system = Akka.system();

        //uncomment this line to enable the creation of the TweetService once TweetService has been created
        //tweetServiceClient = system.actorOf(TweetService.props(), "tweetServiceClient");
    }
}
