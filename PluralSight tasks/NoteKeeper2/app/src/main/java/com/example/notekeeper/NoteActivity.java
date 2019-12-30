package com.example.notekeeper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

public class NoteActivity extends AppCompatActivity {

    public static final String NOTE_POSITION = "com.example.notekeeper.NOTE_POSITION";
    public static final String ORIGINAL_NOTE_COURSE_ID = "com.example.notekeeper.ORIGINAL_NOTE_COURSE_ID";
    public static final String ORIGINAL_NOTE_TITLE = "com.example.notekeeper.ORIGINAL_NOTE_TITLE";
    public static final String ORIGINAL_NOTE_TEXT = "com.example.notekeeper.ORIGINAL_NOTE_TEXT";
    public static final int POSITION_NOT_SET = -1;
    private NoteInfo note;
    private boolean isNewNote;
    private Spinner spinner;
    private EditText textTitle;
    private EditText textBody;
    private int notePosition;
    private boolean isCancelling;
    private String originalNoteCourseID;
    private String originalNoteTitle;
    private String originalNoteText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinner = findViewById(R.id.spinner_courses);

        List<CourseInfo> courses = DataManager.getInstance().getCourses();
        ArrayAdapter<CourseInfo> adapterCourses =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, courses);

        adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterCourses);

        readDisplayStateValues();
        if (savedInstanceState == null){
            saveOriginalNoteValues();
        }else
        {
            restoreOriginalNoteValues(savedInstanceState);
        }
        textTitle = findViewById(R.id.text_note_title);
        textBody = findViewById(R.id.text_note_body);

        if(!isNewNote)
            displayNote(spinner, textTitle, textBody);
    }

    private void restoreOriginalNoteValues(Bundle savedInstanceState) {
        originalNoteCourseID = savedInstanceState.getString(ORIGINAL_NOTE_COURSE_ID);
        originalNoteText = savedInstanceState.getString(ORIGINAL_NOTE_TEXT);
        originalNoteTitle = savedInstanceState.getString(originalNoteTitle);
    }

    private void saveOriginalNoteValues() {
        if (isNewNote)
            return;
        originalNoteCourseID = note.getCourse().getCourseId();
        originalNoteTitle = note.getTitle();
        originalNoteText = note.getText();
    }

    private void displayNote(Spinner spinner, EditText textTitle, EditText textBody) {
        List<CourseInfo> courses = DataManager.getInstance().getCourses();
        int courseIndex = courses.indexOf(note.getCourse());
        spinner.setSelection(courseIndex);

        textTitle.setText(note.getTitle());
        textBody.setText(note.getText());

    }

    private void readDisplayStateValues() {
        Intent intent = getIntent();
        int position = intent.getIntExtra(NOTE_POSITION, POSITION_NOT_SET);
        isNewNote = position == POSITION_NOT_SET;
        if (!isNewNote) {
            note = DataManager.getInstance().getNotes().get(position);
        }else
        {
            createNewNote();
        }
    }

    private void createNewNote() {
        DataManager dm = DataManager.getInstance();
        notePosition = dm.createNewNote();
        note = dm.getNotes().get(notePosition);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(isCancelling) {
            if (isNewNote){
                DataManager.getInstance().removeNote(notePosition);
            }else
            {
                storePreciousNoteValues();
            }
        }else
            saveNote();
    }

    private void storePreciousNoteValues() {
        CourseInfo course = DataManager.getInstance().getCourse(originalNoteCourseID);
        note.setTitle(originalNoteTitle);
        note.setText(originalNoteText);
        note.setCourse(course);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(ORIGINAL_NOTE_COURSE_ID,originalNoteCourseID);
        outState.putString(ORIGINAL_NOTE_TITLE,originalNoteTitle);
        outState.putString(ORIGINAL_NOTE_TEXT,originalNoteTitle);
    }

    private void saveNote() {
        note.setCourse((CourseInfo) spinner.getSelectedItem());
        note.setText(textBody.getText().toString());
        note.setTitle(textTitle.getText().toString());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_send) {
            sendEmail();
        }
        else if (id == R.id.action_cancel)
        {
            isCancelling = true;
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void sendEmail() {
        CourseInfo courseInfo = (CourseInfo) spinner.getSelectedItem();
        String subject = textTitle.getText().toString();
        String text = "Checkout what i learned in the plural sight course\"" +
                courseInfo.getTitle() + "\"\n" + textBody.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND)
            .setType("message/rfc2822")
            .putExtra(Intent.EXTRA_SUBJECT,subject)
            .putExtra(Intent.EXTRA_TEXT, text);
        if(intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);
    }
}
