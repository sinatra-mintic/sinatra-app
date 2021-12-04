package co.listdetail.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import co.listdetail.R
import co.listdetail.adapter.ContactsAdapter
import co.listdetail.model.Contact
import co.listdetail.viewmodel.ContactViewModel
import java.util.ArrayList


/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    private lateinit var mContacts: ArrayList<Contact>
    private lateinit var mAdapter: ContactsAdapter
    private lateinit var recycler: RecyclerView
    private lateinit var model: ContactViewModel
    private lateinit var contexto:Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //val context = requireContext().applicationContext
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model = ViewModelProvider(requireActivity()).get(ContactViewModel::class.java)
        recycler = view.findViewById(R.id.contact_list)
        setupRecyclerView()

    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contexto = context
    }

    /**
     * Sets up the RecyclerView: empty data set, item dividers, swipe to delete.
     */
    private fun setupRecyclerView() {
        mContacts = createMockContacts()
        recycler.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        mAdapter = ContactsAdapter( mContacts,contexto) { contact ->
            contactOnClick(contact)
        }

        recycler.adapter = mAdapter
    }

    /* RecyclerView item is clicked. */
    private fun contactOnClick(contact: Contact) {
        Log.d(TAG, "Click on: $contact")
        model.select(contact)

        if (contact.firstName =="1"){
            findNavController().navigate(R.id.action_listFragment_to_detailFragment)
        }else if (contact.firstName =="2"){
            findNavController().navigate(R.id.action_listFragment_to_top_rock)
        }
        else if (contact.firstName =="3"){
            findNavController().navigate(R.id.action_listFragment_to_ferry_land)
        }
        else if (contact.firstName =="4"){
            findNavController().navigate(R.id.action_listFragment_to_high_line)
        }
        else{
            findNavController().navigate(R.id.action_listFragment_to_vessel)
        }
    }

    private fun createMockContacts(): ArrayList<Contact> {
        return arrayListOf(
            Contact("1","Central Park", "Senderos a pie","co@gmail.com"),
            Contact("2","Top of the rock", "Panorámica de la gran manzana","co@gmail.com"),
            Contact("3","Terry state land", "Ferry gratuito","co@gmail.com"),
            Contact("4","High line", "Parque elevado" ,"co@gmail.com"),
            Contact("5","Vessel", "Zona de rascacielos y lujos","co@gmail.com")
        )
    }

    companion object {
        private val TAG = ListFragment::class.java.simpleName
    }
}