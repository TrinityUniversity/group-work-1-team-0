package controllers

import javax.inject._
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import models.GroupWorkModel

import play.api.mvc._

@Singleton
class Test @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

def test = Action {
    Ok("Lizzie was here")
    Ok(views.html.test("Lizzie"))
    //val test2 = List(1,2,3,4,5)
    //Ok(views.html.test2(test2))
}

def testList = Action {
    Ok(views.html.testList(List(1,2,3,4,5)))
}

// val table:Array[String] = "Player             Team    AVG " +
//       "harden,james          Hou   34.3" +
//       "beal,bradley          Was   30.6" +
//       "lillard,damian        Por   30.0" +
//       "young,trae            Atl   29.6 " +
//       "antetokounmpo,g       Mil   29.5 " +
//       "doncic,luka           Dal   28.8 " +
//       "westbrook,russel      Hou   27.2 " +
//       "leonard,kawhi         LAC   27.1 " +
//       "booker,devin          Pho   26.6 " +
//       "davis,anthony         LAL   26.1".toString.toArray.split("\\s+")
val table2 = """1 embiid,joel        C 30 33.1  285  548 .520  37   90 .411  298  348 .856   7.8 30.2
 2 harris,tobias     SF 31 34.5  241  470 .513  51  127 .402   94  106 .887   5.1 20.2
 3 simmons,ben       PG 31 34.0  192  332 .578   2    7 .286  112  167 .671   5.5 16.1
 4 milton,shake      SG 28 25.2  135  306 .441  31   99 .313   86   97 .887   1.5 13.8
 5 curry,seth        SG 28 29.9  123  262 .469  56  125 .448   48   52 .923   6.3 12.5
 6 green,danny       SG 36 28.3  106  271 .391  80  213 .376   13   20 .650   2.9  8.5
 7 korkmaz,furkan    SG 25 18.7   69  180 .383  39  113 .345   24   30 .800   1.0  8.0
 8 maxey,tyrese      PG 32 16.3  109  242 .450  15   55 .273   22   25 .880  -4.0  8.0
 9 howard,dwight      C 36 15.9   81  138 .587   4   11 .364   53  100 .530  -2.0  6.1
10 mathias,dakota    SG  8 15.5   19   48 .396   8   26 .308    2    6 .333  -3.9  6.0
11 scott,mike        PF 16 17.8   25   60 .417  19   48 .396    1    4 .250  -0.6  4.4
12 joe,isaiah        SG 20 12.0   29   79 .367  23   60 .383    5    5 1.00  -0.8  4.3
13 bradley,tony       C 12 10.5   22   39 .564   0    1 .000    3    5 .600  -0.1  3.9
14 reed,paul         SF  5 11.0    9   22 .409   0    3 .000    0    0 .000   3.4  3.6
15 thybulle,matiss   SG 33 18.1   39  106 .368  17   65 .262    8   14 .571   0.1  3.1
16 poirier,vincent    C  6  3.7    1    4 .250   0    0 .000    2    4 .500  -2.2  0.7
17 ferguson,terran   SF  9  3.9    1    5 .200   0    3 .000    0    0 .000  -1.8  0.2
""".split('\n')
val table3 = table2.map(s => s.split("\\s+"))
def dougstats = Action {
    Ok(views.html.dougstats(table3))
}

def groupWork1 = Action{
    Ok(views.html.groupWork1())
}

def basicGW1(color:String, name:String) = Action {
    Ok(views.html.favoritecolor(color, name))
}
def basicGW2() = Action { request =>
    val answer= request.body.asFormUrlEncoded
    answer.map { value =>
        var name = value("name").head
        if(GroupWorkModel.validateUser(name))
            Ok(views.html.test(name))
        else
            Redirect("/groupWork1")
    
    }.getOrElse(Ok("error"))
}

}