import java.util.*;

public class ProjectManagementQuiz {
    private static class Question {
        String question;
        String answer;

        public Question(String question, String answer) {
            this.question = question;
            this.answer = answer;
        }
    }

    private static List<Question> questions = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int score = 0;
    private static int totalQuestions = 0;

    public static void main(String[] args) {
        initializeQuestions();
        runQuiz();
        showResults();
    }

    private static void initializeQuestions() {
        // Intro und Overview
        questions.add(new Question(
                "Was ist der fundamentale Unterschied zwischen klassischem und agilem Projektmanagement im Hinblick auf das magische Dreieck?",
                "Klassisch: Inhalt fix, Zeit/Kosten variabel (planbasiert)\nAgil: Zeit/Kosten fix, Inhalt variabel (wertbasiert)"
        ));

        questions.add(new Question(
                "Nennen Sie die drei Hauptprobleme von planbasierten Modellen.",
                "1. Fixe Anforderungen\n2. Große Distanz zwischen Management und Entwicklungsteam\n3. Command & Control Führungsstil"
        ));

        questions.add(new Question(
                "Was sind die fünf Kernvorteile des agilen Projektmanagements?",
                "1. Flexibilität\n2. Kundenorientierung\n3. Effizienz\n4. Motivation\n5. Qualität"
        ));

        questions.add(new Question(
                "Welche wichtigen Ereignisse haben die Entwicklung des agilen Projektmanagements geprägt?",
                "1. 1991: Scrum\n2. 1990er: XP\n3. 2001: Agiles Manifest\n4. 2010: DevOps"
        ));

        questions.add(new Question(
                "Beschreiben Sie das Wasserfallmodell nach Benington (1956).",
                "Lineares, sequenzielles Modell mit festen Phasen:\nAnforderungen → Entwurf → Implementation → Überprüfung → Wartung"
        ));

        questions.add(new Question(
                "Was sind die Hauptziele des Projektmanagements?",
                "1. Effizienter Ressourceneinsatz\n2. Termin- und Kosteneinhaltung\n3. Qualitätssicherung\n4. Risikomanagement\n5. Kundenorientierung"
        ));

        questions.add(new Question(
                "Wie unterscheidet sich der agile Ansatz vom traditionellen Projektmanagement in Bezug auf Kundenanforderungen?",
                "Agil: Flexible Anpassung an sich ändernde Anforderungen, iterative Entwicklung\nTraditionell: Fixe Anforderungen zu Projektbeginn, wenig Änderungsmöglichkeiten"
        ));

        questions.add(new Question(
                "Warum wurde das agile Projektmanagement entwickelt?",
                "Als Antwort auf die Schwächen traditioneller Methoden, um besser mit Veränderungen umgehen zu können und schneller Wert für den Kunden zu liefern."
        ));

        // Agiles Manifest
        questions.add(new Question(
                "Nennen Sie die vier Grundwerte des Agilen Manifests.",
                "1. Individuen und Interaktionen mehr als Prozesse und Werkzeuge\n2. Funktionierende Software mehr als umfassende Dokumentation\n3. Zusammenarbeit mit dem Kunden mehr als Vertragsverhandlung\n4. Reagieren auf Veränderung mehr als das Befolgen eines Plans"
        ));

        questions.add(new Question(
                "Was sind die ersten drei der zwölf agilen Prinzipien?",
                "1. Höchste Priorität ist Kundenzufriedenheit durch frühe und kontinuierliche Auslieferung\n2. Anforderungsänderungen sind auch spät in der Entwicklung willkommen\n3. Regelmäßige Lieferung funktionierender Software (bevorzugt kürzere Zeitspanne)"
        ));

        questions.add(new Question(
                "Welche vier konkreten Vorteile bietet die Einführung von Agile?",
                "1. Erhöhte Anpassungsfähigkeit an veränderte Anforderungen\n2. Höhere Kundenzufriedenheit durch regelmäßiges Feedback\n3. Verbesserte Teammoral und -motivation\n4. Schnellere Wertschöpfung durch iterative Entwicklung"
        ));

        questions.add(new Question(
                "Was sind die wichtigsten Prinzipien bezüglich der Teamorganisation im agilen Kontext?",
                "1. Teams sollten selbstorganisiert sein\n2. Tägliche Zusammenarbeit zwischen Entwicklern und Fachexperten\n3. Regelmäßige Team-Reflexion zur Verbesserung der Effektivität\n4. Face-to-Face Kommunikation wird bevorzugt"
        ));

        // Scrum
        questions.add(new Question(
                "Was beschreibt ein 'Product Backlog Item' (PBI) und welche Informationen enthält es typischerweise?",
                "1. Eine kurze Beschreibung/Stichwort der Anforderung\n2. Meist in Form einer User Story\n3. Geschätzte Größe\n4. Details werden erst 1-2 Sprints vor Realisierung ausgearbeitet\n5. Priorisierung basierend auf: Kundenzufriedenheit, Technisches Risiko, Realisierungskosten, Cost of Delay"
        ));

        questions.add(new Question(
                "Nennen Sie die drei Hauptrollen in Scrum und beschreiben Sie deren Hauptverantwortlichkeiten.",
                "1. Product Owner: Verantwortlich für Produktwert, Vision und ROI, Backlog-Pflege\n2. Entwicklungsteam: Selbstorganisierte Gruppe, entwickelt Software und sichert Qualität\n3. Scrum Master: Unterstützt Team und Organisation bei Scrum-Anwendung, beseitigt Hindernisse"
        ));

        questions.add(new Question(
                "Was sind die vier wichtigsten Scrum Events und wann finden diese statt?",
                "1. Sprint Planning: Zu Beginn des Sprints\n2. Daily Scrum: Täglich, max. 15 Minuten\n3. Sprint Review: Am Ende des Sprints\n4. Sprint Retrospektive: Nach dem Review"
        ));

        questions.add(new Question(
                "Was ist der Unterschied zwischen einem Sprint Backlog und einem Product Backlog?",
                "Product Backlog: Gesamtliste aller gewünschten Produktfunktionen, priorisiert\nSprint Backlog: Ausgewählte User Stories für aktuellen Sprint, in Tasks heruntergebrochen"
        ));

        questions.add(new Question(
                "Erklären Sie die 'Definition of Done' und warum sie wichtig ist.",
                "Gemeinsames Verständnis wann eine User Story fertig ist\nBeinhaltet üblicherweise:\n- Funktional vollständig implementiert\n- Getestet und fehlerfrei\n- Auf realistischer Systemumgebung lauffähig\n- Dokumentiert\n- Code-Review durchgeführt"
        ));

        questions.add(new Question(
                "Was sind die drei Säulen von Scrum und was bedeuten sie?",
                "1. Transparenz: Alle relevanten Aspekte müssen für alle sichtbar sein\n2. Inspektion: Regelmäßige Überprüfung der Artefakte und des Fortschritts\n3. Adaption: Anpassung von Prozess und Produkten bei Abweichungen"
        ));

        questions.add(new Question(
                "Beschreiben Sie den Ablauf eines Daily Scrums. Welche drei Fragen werden typischerweise beantwortet?",
                "1. Was habe ich seit dem letzten Daily geschafft?\n2. Was plane ich bis zum nächsten Daily zu tun?\n3. Welche Hindernisse blockieren mich?\n- Maximal 15 Minuten, stehend vor dem Taskboard\n- Keine detaillierten Diskussionen"
        ));

        questions.add(new Question(
                "Was sind die Aufgaben eines Scrum Masters?",
                "1. Team coachen\n2. Team vor Störungen schützen\n3. Impediments beseitigen\n4. Servant Leadership ausüben\n5. Organisatorische Veränderungen unterstützen"
        ));

        questions.add(new Question(
                "Was geschieht in der Sprint Retrospektive und warum ist sie wichtig?",
                "1. Team reflektiert über vergangenen Sprint\n2. Analyse von aufgetretenen Problemen\n3. Identifikation von Verbesserungspotential\n4. Festlegung konkreter Maßnahmen für nächsten Sprint\n5. Kontinuierliche Prozessverbesserung"
        ));

        questions.add(new Question(
                "Welche Informationen enthält eine User Story und wie wird sie typischerweise formatiert?",
                "1. 'Als <Rolle> möchte ich <Feature>, sodass <Wert>'\n2. ID und Name\n3. Beschreibung des Features\n4. Akzeptanzkriterien\n5. Schätzung\n6. Verweise/Annotationen"
        ));

        questions.add(new Question(
                "Erklären Sie das INVEST-Prinzip für User Stories.",
                "1. Independent: Unabhängig von anderen Stories\n2. Negotiable: Inhalt verhandelbar\n3. Valuable: Bietet Mehrwert\n4. Estimable: Schätzbar\n5. Small: In einem Sprint umsetzbar\n6. Testable: Akzeptanzkriterien prüfbar"
        ));

        questions.add(new Question(
                "Was ist der Unterschied zwischen einem 'Commitment' und einem 'Forecast' im Sprint Planning?",
                "Commitment: Verbindliche Zusage des Teams zur Umsetzung der User Stories\nForecast: Realistische Einschätzung was im Sprint geschafft werden kann, basierend auf Erfahrung"
        ));

        questions.add(new Question(
                "Was sind die drei wichtigsten Artefakte in Scrum und was ist ihre jeweilige Bedeutung?",
                "Die drei Hauptartefakte sind: Product Backlog (priorisierte Liste aller Anforderungen), Sprint Backlog (ausgewählte Tasks für einen Sprint) und Product Increment (funktionierendes Softwareprodukt)."
        ));

        // Agiles schätzen und planen
        questions.add(new Question(
                "Was bedeutet das Akronym INVEST bei User Stories und warum ist es wichtig?",
                "INVEST steht für Independent (unabhängig), Negotiable (verhandelbar), Valuable (wertvoll), Estimable (schätzbar), Small (klein) und Testable (testbar). Diese Kriterien helfen bei der Erstellung qualitativ hochwertiger User Stories."
        ));

        questions.add(new Question(
                "Welche Schätzmethoden werden im agilen Projektmanagement verwendet und wie unterscheiden sie sich?",
                "Die wichtigsten Methoden sind T-Shirt Sizing (XS-XL), Planning Poker (mit Fibonacci-Zahlen) und Magic Estimation (Aufwand vs. Wert)."
        ));

        questions.add(new Question(
                "Was ist der Hauptzweck eines Product Backlog Refinements?",
                "Das Refinement dient der detaillierten Diskussion von User Stories, der Schätzung durch das Team und der Aufteilung zu großer Stories in kleinere Einheiten."
        ));

        // Kanban
        questions.add(new Question(
                "Was bedeutet der Begriff 'Kanban' ursprünglich und woher stammt er?",
                "Kanban bedeutet 'Signalkarte' und stammt aus dem Toyota-Produktionssystem. Es wurde entwickelt, um einen gleichmäßigen Fluss in der Fertigung herzustellen."
        ));

        questions.add(new Question(
                "Welche drei Hauptziele verfolgt Kanban im Projektmanagement?",
                "1. Anzahl paralleler Arbeiten begrenzen (WIP)\n2. Durchlaufzeiten reduzieren\n3. Engpässe/Probleme sichtbar machen"
        ));

        questions.add(new Question(
                "Welche vier Flight Levels nach Klaus Leopold gibt es bei Kanban und was unterscheidet sie?",
                "1. Flight Level 1: Kanban im Team, Input unreguliert\n2. Flight Level 2: Kanban im Team mit reguliertem Input\n3. Flight Level 3: Teamübergreifende Wertschöpfungskette\n4. Flight Level 4: Kanban für das gesamte Wertschöpfungsportfolio"
        ));

        questions.add(new Question(
                "Was sind die Hauptvorteile von WIP-Limits im Kanban-System?",
                "WIP-Limits führen zu weniger Context-Switches, verhindern Überlastung und machen Bottlenecks sichtbar."
        ));

        questions.add(new Question(
                "Welche grundlegenden Prinzipien folgt Kanban?",
                "1. Beginne mit dem, was du gerade tust\n2. Vereinbare inkrementelle, evolutionäre Veränderung\n3. Respektiere aktuelle Prozesse und Rollen\n4. Ermutige Führung auf allen Ebenen"
        ));

        // Lean Development
        questions.add(new Question(
                "Was sind die drei grundlegenden japanischen Konzepte des Lean Development und was bedeuten sie?",
                "1. Muri (unmöglich) - optimale Prozessplanung durch gutes Design\n2. Mura (Unebenheiten) - Verhinderung von Fluktuationen in der Implementierung\n3. Muda (nutzlos) - Minimierung von Output-Schwankungen im laufenden Betrieb"
        ));
        questions.add(new Question(
                "Was ist das 'Set-based Design' im Lean Development und welche Vorteile bietet es?",
                "Eine Methode, bei der mehrere Teams parallel verschiedene Lösungsansätze für ein Problem entwickeln. Am Ende wird die beste Lösung oder eine Kombination der besten Elemente ausgewählt. Dies vermeidet frühzeitige Festlegungen und reduziert das Risiko von Fehlentwicklungen."
        ));

        questions.add(new Question(
                "Welche vier Aspekte umfasst das 'Team Empowerment' im Lean Development?",
                "Work Out (Manager unterstützen statt kontrollieren), keine 'Humanressourcen' sondern Wertschätzung, Selbstorganisation des Teams und direkter Kundenzugriff."
        ));

        questions.add(new Question(
                "Was versteht man unter 'Built-in Integrity' und welche Arten gibt es?",
                "Es gibt wahrgenommene Integrität (Kundennutzen), konzeptuelle Integrität (Zusammenarbeit der Komponenten), architektonische Integrität (durch Refactoring) und Integrity Testing (automatisierte Tests)."
        ));

        questions.add(new Question(
                "Welche Vor- und Nachteile hat Lean Software Development?",
                "Vorteile:\n- Schnellere Funktionalitätsbereitstellung\n- Kostensenkung durch Vermeidung unnötiger Aktivitäten\n- mehr Entscheidungskompetenz für Teams\nNachteile:\n- Starke Teamabhängigkeit\n- schwere Skalierbarkeit\n- hoher Dokumentations- und Kommunikationsbedarf"
        ));

        // Scrum Retro
        questions.add(new Question(
                "Was ist eine Sprint Retrospektive und was ist ihr Hauptzweck?",
                "Eine Teamreflexion über den vergangenen Sprint, bei der Probleme, Erfolge und unerwartete Ereignisse analysiert werden, um zukünftige Sprints zu verbessern."
        ));

        questions.add(new Question(
                "Welche 5 Phasen hat eine Sprint Retrospektive?",
                "1. Set the Stage (Zielsetzung)\n2. Gather Data (Faktensammlung)\n3. Generate Insights (Analyse)\n4. Decide what to do (Verbesserungen finden)\n5. Close (Ergebnissicherung)"
        ));

        questions.add(new Question(
                "Was ist die 'Prime Directive' einer Retrospektive und warum ist sie wichtig?",
                "Grundsatz, dass jeder sein Bestes gegeben hat unter den gegebenen Umständen. Wichtig für eine sichere, schuldzuweisungsfreie Diskussionsatmosphäre."
        ));

        questions.add(new Question(
                "Was ist ein Burndown Chart und wozu dient er?",
                "Visuelle Darstellung des Arbeitsfortschritts und der verbleibenden Arbeit. Dient als Mittel zur Selbstorganisation, nicht als Leistungsmessung."
        ));

        questions.add(new Question(
                "Was ist Velocity und wofür sollte sie NICHT verwendet werden?",
                "Velocity misst die in einem Sprint erledigte Arbeit. Sie sollte nicht für Teamvergleiche, Leistungsmessung oder Prämienzahlungen verwendet werden."
        ));

        // Extreme Programming
        questions.add(new Question(
                "Was sind die vier Grundkonzepte von Extreme Programming?",
                "1. Programmieren (funktionierender Code)\n2. Testen (Feature-Verifikation)\n3. Zuhören (Kundenverständnis)\n4. Design (möglichst einfach)"
        ));

        questions.add(new Question(
                "Welche fünf Kernwerte hat XP?",
                "Kommunikation, Einfachheit, Feedback, Respekt und Mut"
        ));

        questions.add(new Question(
                "Was sind die traditionellen Praktiken in XP und ein Beispiel dafür?",
                "Vier Hauptkategorien:\n1. Feingranulares Feedback (z.B. Pair Programming)\n2. Kontinuierlicher Prozess (z.B. Refactoring)\n3. Gemeinsames Verständnis (z.B. Coding Standards)\n4. Entwickler-Wohlfahrt (z.B. nachhaltiges Tempo)"
        ));

        questions.add(new Question(
                "Was sind die wichtigsten Streitpunkte bei XP?",
                "1. Change Control (häufige Änderungen)\n2. Kundenrepräsentant als Single Point of Failure\n3. hohe Anforderungen an Programmierer\n4. beschränkte Teamgröße"
        ));

        questions.add(new Question(
                "Für welche Arten von Projekten ist XP weniger geeignet?",
                "Festpreisprojekte, Projekte mit festen Fertigstellungsterminen und große Teams - XP funktioniert am besten mit kleinen, flexiblen Teams."
        ));
    }

    private static void runQuiz() {
        System.out.println("Willkommen zum Projektmanagement-Quiz!");
        System.out.println("Beantworte die folgenden Fragen. Drücke Enter nach dem Lesen der Frage, um die Antwort zu sehen.");
        System.out.println("Bewerte dich selbst: 1 = Richtig, 0 = Falsch\n");

        Collections.shuffle(questions); // Fragen zufällig mischen

        for (Question q : questions) {
            totalQuestions++;
            System.out.println("\nFrage " + totalQuestions + ":");
            System.out.println(q.question);
            System.out.println("\nDrücke Enter für die Antwort...");
            scanner.nextLine();

            System.out.println("\nAntwort:");
            System.out.println(q.answer);

            System.out.print("\nWar deine Antwort richtig? (1 = Ja, 0 = Nein): ");
            try {
                int result = Integer.parseInt(scanner.nextLine());
                if (result == 1) {
                    score++;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Als falsch gewertet.");
            }

            System.out.println("\n----------------------------------------");
        }
    }

    private static void showResults() {
        System.out.println("\nQuiz beendet!");
        System.out.println("Dein Ergebnis: " + score + " von " + totalQuestions + " Punkten");
        double percentage = (double) score / totalQuestions * 100;
        System.out.printf("Prozentual: %.1f%%\n", percentage);

        if (percentage >= 90) {
            System.out.println("Hervorragend! Du beherrschst das Thema sehr gut!");
        } else if (percentage >= 70) {
            System.out.println("Gut gemacht! Du hast ein solides Verständnis!");
        } else if (percentage >= 50) {
            System.out.println("Bestanden! Aber es gibt noch Raum für Verbesserung.");
        } else {
            System.out.println("Du solltest das Material noch einmal durchgehen.");
        }
    }
}
