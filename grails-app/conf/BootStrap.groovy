import tekdays.TekEvent
import tekdays.TekUser
import tekdays.Sponsor
import tekdays.Sponsorship


class BootStrap {

    def init = { servletContext ->

        new TekUser(fullName: 'Józek Nowak',
            userName: 'jnowak',
            password: 'haslo12',
            email: 'jnowak@poczta.pl',
            website: 'jnowak.pl',
            bio: '''Józek jest przedebeściakiem. Programuje,
            je, pije i żyje.''').save()
        
        new TekUser(fullName: 'Mariusz Wilkołak',
            userName: 'mwilk',
            password: 'haslo00',
            email: 'wilko@wp.pl',
            website: 'wilkolak.pl',
            bio: '''Mariusz programuje od tygodnia.
            Zaprogramował już betoniarkę numeryczną, kocioł parowy 
            i suszarkę na pranie.
            Teraz bierze się za komputery.''').save()
            
        def event1 = new TekEvent(name: 'Mastering Grails',
            city: 'Krakow',
            organizer: TekUser.findByUserName('mwilk'),
            venue: 'Solvay',
            startDate: new Date('5/30/2011'),
            endDate: new Date('6/2/2011'),
            description: '''Coś będzie, czegoś nie będzie, ale generalnie będzie dobrze.
Nic więcej na razie nie wiadomo.
Następna linia nic więcej nie powie.
Kolejna także.
A tutaj jest koniec.''')
        
        if(!event1.save()) {
            event1.errors.allErrors.each { error ->
                println "An error occured with event1: ${error}"
            }
        }
        
        def event2 = new TekEvent(name: 'Bla bla bla - C#',
            city: 'Dobczyce',
            organizer: TekUser.findByFullName('Józek Nowak'),
            venue: 'Zamek',
            startDate: new Date('6/6/2011'),
            endDate: new Date('6/10/2011'),
            description: 'To będzie coś na temat C#...')
        
        if(!event2.save()) {
            event2.errors.allErrors.each { error ->
                println "An error occured with event2: ${error}"}
        }
        
        def g1 = TekEvent.findByName('Mastering Grails')
        g1.addToVolunteers(new TekUser(fullName: 'Kaczor Donald',
            userName: 'kdonald',
            password: 'password1',
            email: 'kd@g.pl',
            website: 'www.www.pl',
            bio: 'Porządkowy.'))

        g1.addToVolunteers(new TekUser(fullName: 'Myszka Miki',
            userName: 'miki',
            password: 'password2',
            email: 'miki@qa.pl',
            website: 'www.miki.com',
            bio: 'Woźna.'))
            
        g1.addToVolunteers(new TekUser(fullName: 'Grimm Reaper',
            userName: 'gr',
            password: 'password4',
            email: 'death@qa.pl',
            website: 'www.death.com',
            bio: 'Developer aż strach.'))
        
        g1.addToRespondents('mail1@az.com')
        g1.addToRespondents('jezz@mailer.com')
        g1.addToRespondents('hanssolo@galaxy.com')
      
        def s1 = new Sponsor(name: 'IBM',
            website: 'ibm.com',
            description: 'This is IBM!').save()
            
        def s2 = new Sponsor(name: 'Google',
            website: 'google.com',
            description: 'Just a google...').save()
            
        def sp1 = new Sponsorship(event: g1,
            sponsor: s1,
            contributionType:'Other',
            description:'Cool T-shirts').save()
            
        def sp2 = new Sponsorship(event: g1,
            sponsor: s2,
            contributionType: 'Venue',
            description: 'They pay!').save()
        
        s1.addToSponsorships(sp1)
        s1.save()
        s2.addToSponsorships(sp2)
        s2.save()
        g1.addToSponsorships(sp1)
        g1.addToSponsorships(sp2)
        
        g1.save()
    }


            
    def destroy = {
    }
}
