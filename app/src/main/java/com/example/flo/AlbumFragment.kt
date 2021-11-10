package com.example.flo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.flo.databinding.FragmentAlbumBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.Gson

class AlbumFragment : Fragment(){
    lateinit var binding: FragmentAlbumBinding
    private var gson : Gson =  Gson()
    val infomation = arrayListOf("수록곡","상세정보","영상")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //fragment에서 binding 초기화
        binding = FragmentAlbumBinding.inflate(inflater, container,false)

        //Home 에서 넘어온 데이터 받아오기
        val albumData = arguments?.getString("album")
        val album = gson.fromJson(albumData,Album::class.java)

        // Home에서 넘어온 데이터를 반영
        setInit(album)


        binding.albumArrowBackIb.setOnClickListener{
            (context as MainActivity).supportFragmentManager.beginTransaction()
                // mainActivity의 frame --> 바꿀 프레그먼트
                .replace(R.id.main_frm, HomeFragment())
                .commitAllowingStateLoss()
        }
//        binding.albumToggleIv.setOnClickListener {
//            setMix(false)
//        }
//        binding.albumToggleOnIv.setOnClickListener {
//            setMix(true)
//        }
//        binding.albumListSong01Layout.setOnClickListener {
//        val text : String =binding.albumSongTitle01.text.toString()+"-"+binding.albumSongSinger01.text.toString();
//            Toast.makeText(activity,"🎶 "+text,Toast.LENGTH_SHORT).show()
//        }
//        binding.albumListSong02Layout.setOnClickListener {
//            val text : String =binding.albumSongTitle02.text.toString()+"-"+binding.albumSongSinger02.text.toString();
//            Toast.makeText(activity,"🎶 "+text,Toast.LENGTH_SHORT).show()
//        }
//        binding.albumListSong03Layout.setOnClickListener {
//            val text : String =binding.albumSongTitle03.text.toString()+"-"+binding.albumSongSinger03.text.toString();
//            Toast.makeText(activity,"🎶 "+text,Toast.LENGTH_SHORT).show()
//        }
//        binding.albumListSong04Layout.setOnClickListener {
//            val text : String =binding.albumSongTitle04.text.toString()+"-"+binding.albumSongSinger04.text.toString();
//            Toast.makeText(activity,"🎶 "+text,Toast.LENGTH_SHORT).show()
//        }
        //activity에서 setContentView와 같음음

        val albumAdapter = AlbumViewPagerAdapter(this)
        binding.albumContentVp.adapter = albumAdapter
        TabLayoutMediator(binding.albumContentTb,binding.albumContentVp){
                tab, position ->
            tab.text = infomation[position]
        }.attach()
       return binding.root
    }

    private fun setInit(album: Album) {
        binding.albumAlbumCoverIv.setImageResource(album.coverImg!!)
        binding.albumNameTv.text = album.title.toString()
        binding.albumSingerTv.text = album.singer.toString()
    }

    private fun setMix(b: Boolean) {
//        if(b){
//            binding.albumToggleIv.visibility=View.VISIBLE;
//            binding.albumToggleOnIv.visibility=View.GONE;
//        }else{
//            binding.albumToggleIv.visibility=View.GONE;
//            binding.albumToggleOnIv.visibility=View.VISIBLE;
//        }

    }

}