package tekdays

class Message {

	String subject
	String content
	Message parent
	TekEvent event
	TekUser author

	static belongsTo = TekEvent

    static constraints = {
		subject(blank:false)
		content(blank:false, maxSize:2000)
		parent(nullable:true)
		author(nullable:false)
    }
}
