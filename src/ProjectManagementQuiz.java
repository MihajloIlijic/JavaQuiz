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

        // Füge alle weiteren Fragen hinzu...
        questions.add(new Question(
                "Was ist der Unterschied zwischen einem Sprint Backlog und einem Product Backlog?",
                "Product Backlog: Gesamtliste aller gewünschten Produktfunktionen, priorisiert\nSprint Backlog: Ausgewählte User Stories für aktuellen Sprint, in Tasks heruntergebrochen"
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

        // Lean Development
        questions.add(new Question(
                "Was sind die drei grundlegenden japanischen Konzepte des Lean Development und was bedeuten sie?",
                "1. Muri (unmöglich) - optimale Prozessplanung durch gutes Design\n2. Mura (Unebenheiten) - Verhinderung von Fluktuationen in der Implementierung\n3. Muda (nutzlos) - Minimierung von Output-Schwankungen im laufenden Betrieb"
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