package tekdays

class TekEvent {

	String city
	String name
	TekUser organizer
	String venue
	Date startDate
	Date endDate
	String description
	
    static hasMany = [volunteers : TekUser,
        respondents : String,
        sponsorships : Sponsorship,
		tasks : Task,
		messages: Message]
    
    static constraints = {
        name(blank:false)
        city(blank:false)
        description(maxSize:5000)
        organizer()
        venue()
        startDate()
        endDate()
        volunteers(nullable:true)
        respondents(nullable:true)
        sponsorships(nullable:true)
		tasks(nullable:true)
		messages(nullable:true)
    }


    
	String toString() {
		"$name, $city"
	}

}
