package tekdays

import grails.test.*

class TekEventTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testToString() {
		def tekEvent = new TekEvent(name: 'Groovy One',
							city: 'Krakow',
							organizer: 'Jan Kowalski',
							venue: 'Solvay',
							startDate: new Date('5/20/2011'),
							endDate: new Date('5/22/2011'),
							description: 'What a cool event!')
		assertEquals 'Groovy One, Krakow', tekEvent.toString()
    }
}
