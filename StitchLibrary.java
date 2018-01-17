package stitchCounter;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum StitchLibrary
{
	ALT("alternate", 0, 0),
	APPROX("approximately", 0, 0),
	BARINC("knit 1 stitch in front then in back", 2, 0),
	BEG("begin", 0, 0),
	BO("bind off", 0, 0),
	CA("color A", 0, 0),
	CB("color B", 0, 0),
	CC("contrasting color", 0, 0),
	CM("centimeter", 0, 0),
	CN("cable needle", 0, 0),
	CO("cast on", 1, 0), 
	CONT("continue", 0, 0),
	DEC("decrease", -1, 0),
	DPN("double pointed needle", 0, 0),
	FB("front then back", 0, 0),
	FANDB("front then back", 0, 0),
	FL("front loops", 0, 0),
	FOLL("following", 0, 0),
	G("gram", 0, 0),
	INC("increase", 2, 1),
	INCS("increases", 1, 0),
	INCL("including", 0, 0),
	K("knit", 1, 1), 
	KB("knit through back look - KTBL", 1, 0),
	KFB("knit 1 stitch in front, then in back", 2, 0),
	K2TOG("knit 2 stitches together",-1, 0),
	KLL("knit left loop - an increase", 2, 0),
	KRL("knit right loop - an increase", 2, 0),
	KTBL("knit through back loop", 1, 0),
	KWISE("knitwise", 0, 0),
	LC("left cross (to work a cable)", 1, 0),
	LH("left hand", 0, 0),
	LP("loop", 0, 0),
	LPS("loops", 0, 0),
	LT("left twist", 1, 0),
	M("meters", 0, 0),
	M1("make 1 stitch", 1, 0),
	M1A("make 1 away - an increase", 2, 0),
	M1B("make 1 stitch (back) - an increase", 2, 0),
	M1F("make 1 stitch (front) - an increase", 2, 0),
	M1L("make 1 (front/left) - an increase", 2, 0),
	M1R("make 1 (back/right) - an increase", 2, 0),
	M1T("make 1 stitch towards - an increase", 2, 0),
	M1PST("make 1 purl stitch", 1, 0),
	MB("make 1 bubble", 1, 0),
	MC("main color", 0, 0),
	MM("millimeter", 0, 0),
	MMS("millimeters", 0, 0),
	NDL("needle", 0, 0),
	NDLS("needles", 0, 0),
	NO("number", 0, 0),
	OZ("ounce", 0, 0),
	P("purl", 1, 1),
	PB("purl stitch in row below, p tbl", 1, 0),
	PUP("pick up and purl", 1, 0),
	PAT("pattern", 0, 0),
	PATS("patterns", 0, 0),
	PATT("pattern", 0, 0),
	PATTS("patterns", 0, 0),
	PFB("purl 1 stitch in front, then in back", 2, 0),
	PM("place marker", 0, 0),
	PNSO("pass next stitch over", -1, 0),
	POP("popcorn", 1, 0),
	PU("pick up stitches", 0, 0),
	P2TOG("purl 2 stitches together", -1, 0),
	PR("previous row or round", 0, 0),
	PREV("previous", 0, 0),
	PSSO("pass slipped stitch over", -1, 0),
	PTBL("purl through back loop", 1, 0),
	PWISE("purl wise", 0, 0),
	R("row", 0, 0),
	RC("right cross (to work a cable(", 1, 0),
	REM("remaining", 0, 0),
	REP("repeat", 0, 0),
	REPS("repeats", 0, 0),
	REVSTST("reverse stocking stitch", 1, 0),
	RH("right hand", 1, 0),
	RIB("ribbing", 0, 0),
	RND("round", 0, 0),
	RNDS("rounds", 0, 0),
	RS("right side", 0, 0),
	RT("right twist", 1, 0),
	S("slip stitch", -1, 0),
	SC("single crochet", 1, 0),
	SLIPKNOT("slip knot - adjustable loop for cast on", 0, 0),
	SK("skip", -1, 0),
	SKP("slip, knit, pass stitch over—one stitch decreased", -1, 0),
	SKPO("slip, knit, pass stitch over—one stitch decreased", -1, 0),
	SK2P("slip 1, knit 2 together, pass slip stitch over the k2tog " 
			+ "- 2 stitches decreased", -2, 0),
	SL("slip stitch", -1, 0),
	SL1K("slip 1 knitwise", -1, 0),
	SL1P("slip 1 purlwise", -1, 0),
	SLST("slip stitches", -1, 0),
	SS("slip stitch", -1, 0),
	SSK("slip, slip, knit 2 stiches together—a decrease", -1, 0),
	SSSK("slip, slip, slip, knit 3 stitches together - 2 decreased", -2, 0),
	SP("space", 0, 0),
	SSP("slip, slip, purl 2 stiches together—a decrease", -1, 0),
	SPS("spaces", 0, 0),
	ST("stitch", 0, 0),
	STS("stitches", 0, 0),
	STST("stocking stitch", 0, 0),
	TBL("through back loop", 0, 0),
	TFL("through front loop", 0, 0),
	TOG("together", 0, 0),
	WE("work even", 0, 0),
	WON("wool over needle", 0, 0),
	WRN("wool around needle", 0, 0),
	WS("wrong side", 0, 0),
	WYIB("with yarn in back", 0, 0),
	WYIF("with yarn in front", 0, 0),
	YB("yarn back", 0, 0),
	YBK("yarn back", 0, 0),
	YD("yard", 0, 0),
	YDS("yards", 0, 0),
	YF("yarn forward", 0, 0),
	YFON("yarn forward over needle - same as YO", -1, 0),
	YFRN("yarn forward around needle - same as YO", -1, 0),
	YFWD("yarn forward", 0, 0),
	YO("yarn over", 1, 0),
	//YO2("yarn over twice", -2, 0), // consider removing?
	YOTWICE("yarn over twice", -2, 0),
	YRN("yarn around - same as YO", -1, 0),
	YON("yarn over needle - same as YO", -1, 0),
	
	TWICE("twice", 2, 0),
	THREE("three", 3, 0),
	//TIMES("times", 1, 0),
	//X("times", 1, 0),
	
	ERROR("error", -100, 0)
	;
	
	private static final Map<String, StitchLibrary> nameToValueMap = new HashMap<String, StitchLibrary>();
	static
	{
		for(StitchLibrary value : EnumSet.allOf(StitchLibrary.class))
			nameToValueMap.put(value.name(), value);
	}
	
	private final String name;
	private final int value;
	private final int numStIntoPrevRow;
	
	StitchLibrary(String name, int value, int numStIntoPrevRow)
	{
		this.name = name;
		this.value = value;
		this.numStIntoPrevRow = numStIntoPrevRow;

	} // end StitchLibrary constructor

	public String getName()
	{
		return this.name;

	} // end getName

	public int getValue()
	{
		return this.value;

	} // end getValue
	
	public int getNumStIntoPrevRow()
	{
		return this.numStIntoPrevRow;

	} // end getNumStIntoPrevRow
	
	public static StitchLibrary forName(String name)
	{
		return nameToValueMap.get(name);
		
	} // end forName
	
	public static boolean isValidStitch(String term)
	{
		return nameToValueMap.containsKey(term);
		
	} // end contains
	
	public static StitchLibrary getStitchType(String term)
	{
		StitchLibrary stitch;
		
		switch(term)
		{
			case "KNIT":
			case "2X":
			case "2 TIMES": 
			case "TWO TIMES": stitch = StitchLibrary.TWICE; break;
			case "JUDY": stitch = StitchLibrary.ALT; break;
			default: stitch = StitchLibrary.ERROR; break;
			
		} // end switch
		
		return stitch;
		
	} // end getStitchType
	
} // end enum StitchLibrary
