package controllers;

import akka.actor.ActorRef;
import play.Logger;
import play.libs.Akka;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {
  
    public static Result index() {
        return ok(/*index.render("Your new application is ready.")*/);
    }

    public static Result test() {
        ActorRef remoteActor = Akka.system().actorFor("akka://TestSys@localhost:4444/user/echoActor");

        Logger.debug("actor: " + remoteActor);

        remoteActor.tell("what the hell.");

        Logger.debug("seems good. ");
        return ok("toto je test");
    }
  
}
